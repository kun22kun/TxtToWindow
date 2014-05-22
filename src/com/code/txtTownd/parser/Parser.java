/* 
 * @author ��� 
 */
package com.code.txttownd.parser;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import com.code.txttownd.pack.Pack;
import com.code.txttownd.validator.Validator;
import com.code.txttownd.config.Configuration;

/** 
 * ����TXT�е��ֶ�ֵ����HashMap���ͷ���
 */

public class Parser {	
	
	/**
	 * �������·�����ļ�����HashMap<String,String>��ʽ��������������Ϣ
	 * @param fileInParser
	 * @return configsMapRe
	 */
	public static HashMap<String, String> readerIn(File fileInParser) {

		//��String���Ͷ���·�����ļ�����
		String stringFromFile = Importer.importTXT(fileInParser);
		//System.out.println(stringFromFile);
		
		ArrayList<Configuration> listTmp = stringToParse(stringFromFile);

		HashMap<String, String> configsMapRe = Pack.changeLiToMa(listTmp);

		return configsMapRe;
	}
	
	/**
	 * �����ַ�������������Ϣ����HashMap<String,String>��ʽ��������������Ϣ
	 * @param stringFromStr
	 * @return configsMapRe
	 */
	public static HashMap<String, String> readerIn(String stringFromStr) {

		
		//System.out.println(stringFromStr);

		ArrayList<Configuration> listTmp = stringToParse(stringFromStr);

		HashMap<String, String> configsMapRe = Pack.changeLiToMa(listTmp);

		return configsMapRe;
	}
	
	/**
	 * �����ַ�����ʽ������Ϣ������ArrayList<Configuration>��ʽ������Ϣ
	 * @param stringInput
	 * @return ConfigsList
	 */
	public static ArrayList<Configuration> stringToParse(String stringInput) {		

		// ��һ���������ֶμ��ʽ���ؼ����Ƿ���ȷ
		boolean isBtwFlds = Validator.isBetweenFields(stringInput);
		
		ArrayList<Configuration> ConfigsList = new ArrayList<Configuration>();
		if (!isBtwFlds)
			System.out.println("�����ʽ����������������룡");
		
		else {
			System.out.println("*************��ʽ��֤���Ϊ��*************:\n" + isBtwFlds + "\n");

			// �ڶ�������String�ָ�Ϊ���ֶ�Ϊ��λԪ�ص�����
			String[] fieldInParser = Splitter.splitToField(stringInput);
			int len = fieldInParser.length;

			// ��������ͨ�����������ֶηֳ����Σ���ȡ��ÿһ�ε�ֵ
			String fieldSp[][] = new String[len][];

			for (int num = 0; num < len; num++) {

				// ð�ŷָ�������
				// ��Spec�ֶθ�ֵ��Configuration���spec��Ա���� 
				Configuration configTemp = new Configuration();
				fieldSp[num] = Splitter.fieldSplitByColon(fieldInParser[num]);
				configTemp.setSpec(fieldSp[num][1]);
				
				// ȡ�����п��ֵ
				String foreField = fieldSp[num][0];
				String[] valuesOfField = Splitter.fieldValues(foreField);

				// ���Ĳ���������������п��ֵ�Ƿ�Ϸ�
				boolean isInFld = Validator.isInField(valuesOfField);
				if (!isInFld) {
					System.out.println("��" + num + "���ֶ�ֵ���Ϸ���");
					break;
				} else {
					// ���岽����ֵ����Configuration���Ӧ�ĳ�Ա����
					configTemp.setH(Integer.valueOf(valuesOfField[1]));
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
