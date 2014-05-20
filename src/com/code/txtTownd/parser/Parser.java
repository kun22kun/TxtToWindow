/* 
 * @author 骞坤 
 */
package com.code.txttownd.parser;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import com.code.txttownd.validator.Validator;
import com.code.txttownd.config.Configuration;

/**
 * 
 * 解析TXT中的字段值并以HashMap类型返回
 *
 */

public class Parser {

	
	/**
	 * 存储Configuration信息的List</br>&emsp; ArrayList的元素为Configuration对象&emsp;
	 */
	private static ArrayList<Configuration> ConfigsList = new ArrayList<>();

	/**
	 * 存储Configuration信息的Map</br>&emsp; Key(String)为Spec字段</br>&emsp;
	 * Value(int[])依次为行列宽高值&emsp;
	 */

	public static HashMap<String, Integer[]> stringToParse(String stringInput) {

		HashMap<String, Integer[]> ConfigsMap = new HashMap<>();

		// 第二步：检验字段间格式及关键词是否正确
		boolean isBtwFlds = Validator.isBetweenFields(stringInput);
		if (!isBtwFlds)
			System.out.println("输入格式出错，请检查后重新输入！");
		else {
			System.out.println("************检测结果为：" + isBtwFlds);

			// 第三步：将String分隔为以字段为单位元素的数组
			String[] fieldInParser = Splitter.splitToField(stringInput);
			int len = fieldInParser.length;

			// 第四步：通过“：”将字段分成两段，并取出每一段的值
			String fieldSp[][] = new String[len][];

			for (int num = 0; num < len; num++) {

				// 冒号分隔成两段
				// 将Spec字段赋值给Configuration类的spec成员变量 和 HashMap中的Key（String类型）
				Configuration configTemp = new Configuration();
				fieldSp[num] = Splitter.fieldSplitByColon(fieldInParser[num]);
				configTemp.setSpec(fieldSp[num][1]);
				String strInMap = fieldSp[num][1];

				// 取出行列宽高值
				String foreField = fieldSp[num][0];
				String[] valuesOfField = Splitter.fieldValues(foreField);

				// 第五步：检验输入的行列宽高值是否合法
				boolean isInFld = Validator.isInField(valuesOfField);
				if (!isInFld) {
					System.out.println("第" + num + "个字段值不合法！");
					break;
				} else {
					// 第六步：将值赋给Configuration类对应的成员变量
					configTemp.setH(Integer.valueOf(valuesOfField[1]));
					configTemp.setL(Integer.valueOf(valuesOfField[3]) * 2 - 1);
					configTemp.setK(Integer.valueOf(valuesOfField[5]) * 2 - 1);
					configTemp.setG(Integer.valueOf(valuesOfField[7]) * 2 - 1);

					// 同时将值赋给HashMap中的Value（int[]类型）
					Integer[] intInMap = new Integer[4];
					for (int iInMap = 0; iInMap < 4; iInMap++) {
						intInMap[iInMap] = Integer
								.valueOf(valuesOfField[iInMap * 2 + 1]) * 2 - 1;
					}
					// 向ArrayList中添加元素
					ConfigsList.add(configTemp);

					// 向HashMap中添加元素
					ConfigsMap.put(strInMap, intInMap);
				}
			}
		}

		return ConfigsMap;
	}

	public static HashMap<String, Integer[]> ReaderIn(File fileInParser) {

		// 第一步：读入TXT转化为String型
		String readerInParser = Importer.importTXT(fileInParser);
		//System.out.println(readerInParser);

		HashMap<String, Integer[]> configsMapRe = stringToParse(readerInParser);

		return configsMapRe;
	}

	public static HashMap<String, Integer[]> ReaderIn(String stringInParser) {

		// 第一步：读入TXT转化为String型
		//System.out.println(readerInParser);

		HashMap<String, Integer[]> configsMapRe = stringToParse(stringInParser);

		return configsMapRe;
	}


	/**
	 * 以ArrayList形式获取输入内容</br>&emsp; ArrayList的元素为Configuration对象&emsp;
	 * 
	 * @return ArrayList < Configuration >&emsp;
	 */
	public static ArrayList<Configuration> getConfigsList() {
		return ConfigsList;
	}

}
