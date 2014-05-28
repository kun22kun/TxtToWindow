/* 
 * ����  ��� 2014��5��10��  16:20
 */
package com.code.txttownd.parser;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;

import com.code.txttownd.pack.Pack;
import com.code.txttownd.validator.ContentException;
import com.code.txttownd.validator.Validator;
import com.code.txttownd.config.Configuration;

/** 
 * ����TXT�е��ֶ�ֵ����HashMap���ͷ���
 */

public class Parser {
	/**
	 * ֵ��֤��������ֵ
	 */
	public static final int ROW_IN_CANVAS = 25;
	/**
	 * ֵ��֤��������ֵ
	 */
	public static final int COLUMN_IN_CANVAS = 4;
	
	/**
	 * �������·�����ļ�����HashMap<String,String>��ʽ��������������Ϣ
	 * @param fileInParser
	 * @return configsMapRe
	 * @throws ContentException 
	 */
	public static HashMap<String, String> readerIn(File fileInParser) throws ContentException {

		//��String���Ͷ���·�����ļ�����
		String stringFromFile = Importer.importTXT(fileInParser);
		//System.out.println(stringFromFile);
		
		//����һ�������
		String[] strDivToFirCon = StringUtils.split(stringFromFile, "\n", 2);
		
		System.out.println(strDivToFirCon[1]);
		
		//��������Ϣ������ȡ����֤
		ArrayList<Configuration> listTmp = stringToParse(strDivToFirCon[1]);

		HashMap<String, String> configsMapRe = Pack.changeLiToMa(listTmp);
		
		//����һ�м��뵽HashMap��
		configsMapRe.put("control.conf", strDivToFirCon[0]);

		return configsMapRe;
	}
	
	/**
	 * �����ַ�������������Ϣ����HashMap<String,String>��ʽ��������������Ϣ
	 * @param stringFromStr
	 * @return configsMapRe
	 * @throws ContentException 
	 */
	public static HashMap<String, String> readerIn(String stringFromStr) throws ContentException {

		
		//System.out.println(stringFromStr);
		//����һ�������
		String[] strDivToFirCon = StringUtils.split(stringFromStr, "\n", 2);
		
		//��������Ϣ������ȡ����֤
		ArrayList<Configuration> listTmp = stringToParse(strDivToFirCon[1]);

		HashMap<String, String> configsMapRe = Pack.changeLiToMa(listTmp);
		
		//����һ�м��뵽HashMap��
		configsMapRe.put("control.conf", strDivToFirCon[0]);

		return configsMapRe;
	}
	
	/**
	 * �����ַ�����ʽ������Ϣ������ArrayList<Configuration>��ʽ������Ϣ
	 * @param stringInput
	 * @return ConfigsList
	 * @throws ContentException 
	 */
	public static ArrayList<Configuration> stringToParse(String stringInput) throws ContentException {		

		// ��һ���������ֶμ��ʽ���ؼ����Ƿ���ȷ
		boolean isBtwFlds = Validator.isBetweenFields(stringInput);
		
		ArrayList<Configuration> ConfigsList = new ArrayList<Configuration>();
		
		if (!isBtwFlds){
//			System.out.println("�����ʽ����������������룡");
			throw new ContentException("�����ʽ����������������룡");
		}
		else {
			System.out.println("*************��ʽ��֤���Ϊ��*************:\n" + isBtwFlds + "\n");

			// �ڶ�������String�ָ�Ϊ���ֶ�Ϊ��λԪ�ص�����
			String[] fieldInParser = Splitter.splitToField(stringInput);
			int len = fieldInParser.length;

			// ��������ͨ�����������ֶηֳ����Σ���ȡ��ÿһ�ε�ֵ
			String fieldSp[][] = new String[len][];
			
			//����ֵ��֤��Boolean�ͻ���
			boolean [][] canvasToparse = new boolean[ROW_IN_CANVAS][COLUMN_IN_CANVAS];
			

			for (int num = 0; num < len; num++) {

				// ð�ŷָ�������
				// ��Spec�ֶθ�ֵ��Configuration���spec��Ա���� 
				Configuration configTemp = new Configuration();
				fieldSp[num] = Splitter.fieldSplitByColon(fieldInParser[num]);
				configTemp.setSpec(fieldSp[num][1]);
				
				// ȡ�����п��ֵ
				String numsInField = fieldSp[num][0];
				String[] valuesOfField = Splitter.fieldValues(numsInField);

				// ���Ĳ���������������п��ֵ�Ƿ�Ϸ�
				System.out.println("***************���ӵ�"+(num+1)+"���ؼ��󻭲����******************");
				boolean isInFld = Validator.isInField(valuesOfField,canvasToparse,ROW_IN_CANVAS,COLUMN_IN_CANVAS);
				if (!isInFld) {					
					throw new ContentException("\n��" + (num+1) + "���ؼ����ݴ������⣡\n");
				} else {
					// ���岽����ֵ����Configuration���Ӧ�ĳ�Ա����
					configTemp.setH(Integer.valueOf(valuesOfField[1]) * 2 - 1);
					configTemp.setL(Integer.valueOf(valuesOfField[3]) * 2 - 1);
					configTemp.setK(Integer.valueOf(valuesOfField[5]) * 2 - 1);
					configTemp.setG(Integer.valueOf(valuesOfField[7]) * 2 - 1);					
					
					// ����������ArrayList�����Ԫ��
					ConfigsList .add(configTemp);
				}
			}
		}

		return ConfigsList;
	}

}
