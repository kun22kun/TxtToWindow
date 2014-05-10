package com.code.txtTownd.parser;

import java.awt.List;
import java.io.*;
import java.util.ArrayList;

import com.code.txtTownd.config.Configuration;
import com.code.txtTownd.validator.Validator;

/**
 * 
 * 	����TXT�е��ֶ�ֵ
 *
 * @author ���
 */

public class Parser {
	
	/**
	 * �洢���������
	 **/
	private static String readerInParser = null;
	/**
	 * �洢Configuration��Ϣ�б�
	 */
	private static ArrayList<Configuration> ConfigS = new ArrayList<>();

	
	public static void ReaderIn(){
		
		/*
		 * ��һ��������TXTת��ΪString��
		 */
		File fileInParser = new File("E:\\Aero\\Test.txt");
		readerInParser = Importer.importTXT(fileInParser);
//		System.out.println(readerInParser);
		
		/*
		 * �ڶ����������ֶμ��ʽ
		 */
		boolean isBtwFlds = Validator.isBetweenFields(readerInParser);
		System.out.println("************�����Ϊ��"+isBtwFlds);
		
		 /*
		  * ����������String�ָ�Ϊ�ֶι��ɵ�����
		  */
		String[] fieldInParser = Splitter.splitToField(readerInParser);		
		int len = fieldInParser.length;
		
		 /*
		  * ���Ĳ���ͨ�����������ֶηֳ����Σ���ȡ��ÿһ�ε�ֵ
		  */
		String fieldSp[][] = new String[len][];
		
		for(int num=0;num<len;num++){
			
			//ð�ŷָ������β���ֵSpec�ֶθ�Configuration��
			Configuration configTemp = new Configuration();
			fieldSp[num] = Splitter.fieldSplitByColon(fieldInParser[num]);
			configTemp.setSpec(fieldSp[num][1]);
			
			//ȡ����λ���ֵ
			String foreField = fieldSp[num][0];
			String[] valueField = Splitter.fieldValues(foreField);	
			
			
			//��ֵ����Configuration���Ӧ�ĳ�Ա����			
			configTemp.setH(Integer.valueOf(valueField[1]));
			configTemp.setL(Integer.valueOf(valueField[3]));
			configTemp.setK(Integer.valueOf(valueField[5]));
			configTemp.setG(Integer.valueOf(valueField[7]));			
						
			ConfigS.add(num,configTemp);			
		}
		
	}

	public static String getReaderInParser() {
		return readerInParser;
	}

	public static ArrayList<Configuration> getConfigS() {
		return ConfigS;
	}
	
	

}

