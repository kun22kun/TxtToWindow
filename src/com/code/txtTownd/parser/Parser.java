package com.code.txttownd.parser;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import com.code.txttownd.validator.Validator;
import com.code.txttownd.config.Configuration;

/**
 * @author ���</br></br> 
 * 
 * 	����TXT�е��ֶ�ֵ����HashMap���ͷ���
 *
 */

public class Parser {
	
	/**
	 * �洢���������
	 */
	private static String readerInParser = null;
	/**
	 * �洢Configuration��Ϣ��List</br>&emsp;
	 *  ArrayList��Ԫ��ΪConfiguration����&emsp;
	 */
	private static ArrayList<Configuration> ConfigsList = new ArrayList<>();
	/**
	 * �洢Configuration��Ϣ��Map</br>&emsp;
	 *  Key(String)ΪSpec�ֶ�</br>&emsp;
	 *  Value(int[])����Ϊ���п��ֵ&emsp;
	 */
	private static HashMap<String, Integer[]>  ConfigsMap = new HashMap<>();

	
	public static HashMap<String, Integer[]> ReaderIn(File fileInParser){
		
		//��һ��������TXTת��ΪString��		
		readerInParser = Importer.importTXT(fileInParser);
//		System.out.println(readerInParser);
		
		//�ڶ����������ֶμ��ʽ���ؼ����Ƿ���ȷ	 
		boolean isBtwFlds = Validator.isBetweenFields(readerInParser);
		if(!isBtwFlds)
			System.out.println("�����ʽ����������������룡");
		else {
			System.out.println("************�����Ϊ��" + isBtwFlds);

			// ����������String�ָ�Ϊ���ֶ�Ϊ��λԪ�ص�����			 
			String[] fieldInParser = Splitter.splitToField(readerInParser);
			int len = fieldInParser.length;

			
			// ���Ĳ���ͨ�����������ֶηֳ����Σ���ȡ��ÿһ�ε�ֵ			
			String fieldSp[][] = new String[len][];

			for (int num = 0; num < len; num++) {

				// ð�ŷָ�������
				// ��Spec�ֶθ�ֵ��Configuration���spec��Ա���� �� HashMap�е�Key��String���ͣ�
				Configuration configTemp = new Configuration();
				fieldSp[num] = Splitter.fieldSplitByColon(fieldInParser[num]);
				configTemp.setSpec(fieldSp[num][1]);
				String strInMap = fieldSp[num][1];

				// ȡ�����п��ֵ
				String foreField = fieldSp[num][0];
				String[] valuesOfField = Splitter.fieldValues(foreField);				
				
				//���岽��������������п��ֵ�Ƿ�Ϸ�
				boolean isInFld = Validator.isInField(valuesOfField);
				if(!isInFld){
					System.out.println("��"+num+"���ֶ�ֵ���Ϸ���");
					break;
				}
				else {
					//����������ֵ����Configuration���Ӧ�ĳ�Ա����
					configTemp.setH(Integer.valueOf(valuesOfField[1]));
					configTemp.setL(Integer.valueOf(valuesOfField[3]));
					configTemp.setK(Integer.valueOf(valuesOfField[5]));
					configTemp.setG(Integer.valueOf(valuesOfField[7]));
					
					//ͬʱ��ֵ����HashMap�е�Value��int[]���ͣ�
					Integer[] intInMap = new Integer[4];
					for(int iInMap=0 ; iInMap < 4; iInMap++){
						intInMap[iInMap] = Integer.valueOf(valuesOfField[iInMap*2+1]);
					}					
					//��ArrayList�����Ԫ��
					ConfigsList.add(configTemp);
					
					//��HashMap�����Ԫ��
					ConfigsMap.put(strInMap, intInMap);
				}
			}
		}
		return ConfigsMap;		
	}
	
	/**
	 * ���ַ�����ʽ��ȡ��������
	 * @return String
	 */
	public static String getReaderInParser() {
		return readerInParser;
	}
	/**
	 * ��ArrayList��ʽ��ȡ��������</br>&emsp;
	 *  ArrayList��Ԫ��ΪConfiguration����&emsp;
	 * @return ArrayList < Configuration >&emsp;
	 */
	public static ArrayList<Configuration> getConfigsList() {
		return ConfigsList;
	}
	/**
	 * ��HashMap��ʽ��ȡ��������</br>&emsp;
	 *  Key��String���ͣ�ΪSpec�ֶ�</br>&emsp;
	 *  Value��int[]���ͣ�����Ϊ���п��ֵ&emsp;
	 * @return HashMap < String, Integer[] >
	 */
	public static HashMap<String, Integer[]> getConfigsMap() {
		return ConfigsMap;
	}

	
}

