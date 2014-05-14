package com.code.txttownd.parser;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import com.code.txttownd.validator.Validator;
import com.code.txttownd.config.Configuration;

/**
 * @author 骞坤
 * 
 * 	解析TXT中的字段值并以HashMap类型返回
 *
 */

public class Parser {
	
	/**
	 * 存储读入的内容
	 */
	private static String readerInParser = null;
	/**
	 * 存储Configuration信息列表
	 */
	private static ArrayList<Configuration> ConfigsList = new ArrayList<>();
	
	private static HashMap<String, Integer[]>  ConfigsMap = new HashMap<>();

	
	public static HashMap<String, Integer[]> ReaderIn(File fileInParser){
		
		//第一步：读入TXT转化为String型	 
		
		readerInParser = Importer.importTXT(fileInParser);
//		System.out.println(readerInParser);
		
		//第二步：检验字段间格式及关键词是否正确	 
		boolean isBtwFlds = Validator.isBetweenFields(readerInParser);
		if(!isBtwFlds)
			System.out.println("输入格式出错，请检查后重新输入！");
		else {
			System.out.println("************检测结果为：" + isBtwFlds);

			// 第三步：将String分隔为字段构成的数组			 
			String[] fieldInParser = Splitter.splitToField(readerInParser);
			int len = fieldInParser.length;

			
			// 第四步：通过“：”将字段分成两段，并取出每一段的值			
			String fieldSp[][] = new String[len][];

			for (int num = 0; num < len; num++) {

				// 冒号分隔成两段并赋值Spec字段给Configuration类
				Configuration configTemp = new Configuration();
				fieldSp[num] = Splitter.fieldSplitByColon(fieldInParser[num]);
				configTemp.setSpec(fieldSp[num][1]);
				String strInMap = fieldSp[num][1];

				// 取出方位宽高值
				String foreField = fieldSp[num][0];
				String[] valuesOfField = Splitter.fieldValues(foreField);				
				
				//第五步：检验输入的行列宽高值是否合法
				boolean isInFld = Validator.isInField(valuesOfField);
				if(!isInFld){
					System.out.println("第"+num+"个字段值不合法！");
					break;
				}
				else {
					//第六步：将值赋给Configuration类对应的成员变量
					configTemp.setH(Integer.valueOf(valuesOfField[1]));
					configTemp.setL(Integer.valueOf(valuesOfField[3]));
					configTemp.setK(Integer.valueOf(valuesOfField[5]));
					configTemp.setG(Integer.valueOf(valuesOfField[7]));
					
					Integer[] intInMap = new Integer[4];
					for(int iInMap=0 ; iInMap < 4; iInMap++){
						intInMap[iInMap] = Integer.valueOf(valuesOfField[iInMap*2+1]);
					}					

					ConfigsList.add(configTemp);
					
					//赋值给HashMap
					ConfigsMap.put(strInMap, intInMap);
				}
			}
		}
		return ConfigsMap;		
	}

	public static String getReaderInParser() {
		return readerInParser;
	}

	public static ArrayList<Configuration> getConfigsList() {
		return ConfigsList;
	}

	public static HashMap<String, Integer[]> getConfigsMap() {
		return ConfigsMap;
	}

	
}

