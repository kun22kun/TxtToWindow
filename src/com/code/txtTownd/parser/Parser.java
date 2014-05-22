/* 
 * @author 骞坤 
 */
package com.code.txttownd.parser;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import com.code.txttownd.pack.Pack;
import com.code.txttownd.validator.Validator;
import com.code.txttownd.config.Configuration;

/** 
 * 解析TXT中的字段值并以HashMap类型返回
 */

public class Parser {	
	
	/**
	 * 读入给定路径下文件，以HashMap<String,String>格式返回所有配置信息
	 * @param fileInParser
	 * @return configsMapRe
	 */
	public static HashMap<String, String> readerIn(File fileInParser) {

		//以String类型读入路径下文件内容
		String stringFromFile = Importer.importTXT(fileInParser);
		//System.out.println(stringFromFile);
		
		ArrayList<Configuration> listTmp = stringToParse(stringFromFile);

		HashMap<String, String> configsMapRe = Pack.changeLiToMa(listTmp);

		return configsMapRe;
	}
	
	/**
	 * 读入字符串类型配置信息，以HashMap<String,String>格式返回所有配置信息
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
	 * 读入字符串格式配置信息，返回ArrayList<Configuration>格式配置信息
	 * @param stringInput
	 * @return ConfigsList
	 */
	public static ArrayList<Configuration> stringToParse(String stringInput) {		

		// 第一步：检验字段间格式及关键词是否正确
		boolean isBtwFlds = Validator.isBetweenFields(stringInput);
		
		ArrayList<Configuration> ConfigsList = new ArrayList<Configuration>();
		if (!isBtwFlds)
			System.out.println("输入格式出错，请检查后重新输入！");
		
		else {
			System.out.println("*************格式验证结果为：*************:\n" + isBtwFlds + "\n");

			// 第二步：将String分隔为以字段为单位元素的数组
			String[] fieldInParser = Splitter.splitToField(stringInput);
			int len = fieldInParser.length;

			// 第三步：通过“：”将字段分成两段，并取出每一段的值
			String fieldSp[][] = new String[len][];

			for (int num = 0; num < len; num++) {

				// 冒号分隔成两段
				// 将Spec字段赋值给Configuration类的spec成员变量 
				Configuration configTemp = new Configuration();
				fieldSp[num] = Splitter.fieldSplitByColon(fieldInParser[num]);
				configTemp.setSpec(fieldSp[num][1]);
				
				// 取出行列宽高值
				String foreField = fieldSp[num][0];
				String[] valuesOfField = Splitter.fieldValues(foreField);

				// 第四步：检验输入的行列宽高值是否合法
				boolean isInFld = Validator.isInField(valuesOfField);
				if (!isInFld) {
					System.out.println("第" + num + "个字段值不合法！");
					break;
				} else {
					// 第五步：将值赋给Configuration类对应的成员变量
					configTemp.setH(Integer.valueOf(valuesOfField[1]));
					configTemp.setL(Integer.valueOf(valuesOfField[3]) * 2 - 1);
					configTemp.setK(Integer.valueOf(valuesOfField[5]) * 2 - 1);
					configTemp.setG(Integer.valueOf(valuesOfField[7]) * 2 - 1);					
					
					// 第六步：向ArrayList中添加元素
					ConfigsList .add(configTemp);
				}
			}
		}

		return ConfigsList;
	}

}
