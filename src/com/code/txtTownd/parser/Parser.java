/* 
 * @author ��� 
 */
package com.code.txttownd.parser;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import com.code.txttownd.validator.Validator;
import com.code.txttownd.config.Configuration;

/**
 * 
 * ����TXT�е��ֶ�ֵ����HashMap���ͷ���
 *
 */

public class Parser {

	
	/**
	 * �洢Configuration��Ϣ��List</br>&emsp; ArrayList��Ԫ��ΪConfiguration����&emsp;
	 */
	private static ArrayList<Configuration> ConfigsList = new ArrayList<>();

	/**
	 * �洢Configuration��Ϣ��Map</br>&emsp; Key(String)ΪSpec�ֶ�</br>&emsp;
	 * Value(int[])����Ϊ���п��ֵ&emsp;
	 */

	public static HashMap<String, Integer[]> stringToParse(String stringInput) {

		HashMap<String, Integer[]> ConfigsMap = new HashMap<>();

		// �ڶ����������ֶμ��ʽ���ؼ����Ƿ���ȷ
		boolean isBtwFlds = Validator.isBetweenFields(stringInput);
		if (!isBtwFlds)
			System.out.println("�����ʽ����������������룡");
		else {
			System.out.println("************�����Ϊ��" + isBtwFlds);

			// ����������String�ָ�Ϊ���ֶ�Ϊ��λԪ�ص�����
			String[] fieldInParser = Splitter.splitToField(stringInput);
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

				// ���岽��������������п��ֵ�Ƿ�Ϸ�
				boolean isInFld = Validator.isInField(valuesOfField);
				if (!isInFld) {
					System.out.println("��" + num + "���ֶ�ֵ���Ϸ���");
					break;
				} else {
					// ����������ֵ����Configuration���Ӧ�ĳ�Ա����
					configTemp.setH(Integer.valueOf(valuesOfField[1]));
					configTemp.setL(Integer.valueOf(valuesOfField[3]) * 2 - 1);
					configTemp.setK(Integer.valueOf(valuesOfField[5]) * 2 - 1);
					configTemp.setG(Integer.valueOf(valuesOfField[7]) * 2 - 1);

					// ͬʱ��ֵ����HashMap�е�Value��int[]���ͣ�
					Integer[] intInMap = new Integer[4];
					for (int iInMap = 0; iInMap < 4; iInMap++) {
						intInMap[iInMap] = Integer
								.valueOf(valuesOfField[iInMap * 2 + 1]) * 2 - 1;
					}
					// ��ArrayList�����Ԫ��
					ConfigsList.add(configTemp);

					// ��HashMap�����Ԫ��
					ConfigsMap.put(strInMap, intInMap);
				}
			}
		}

		return ConfigsMap;
	}

	public static HashMap<String, Integer[]> ReaderIn(File fileInParser) {

		// ��һ��������TXTת��ΪString��
		String readerInParser = Importer.importTXT(fileInParser);
		//System.out.println(readerInParser);

		HashMap<String, Integer[]> configsMapRe = stringToParse(readerInParser);

		return configsMapRe;
	}

	public static HashMap<String, Integer[]> ReaderIn(String stringInParser) {

		// ��һ��������TXTת��ΪString��
		//System.out.println(readerInParser);

		HashMap<String, Integer[]> configsMapRe = stringToParse(stringInParser);

		return configsMapRe;
	}


	/**
	 * ��ArrayList��ʽ��ȡ��������</br>&emsp; ArrayList��Ԫ��ΪConfiguration����&emsp;
	 * 
	 * @return ArrayList < Configuration >&emsp;
	 */
	public static ArrayList<Configuration> getConfigsList() {
		return ConfigsList;
	}

}
