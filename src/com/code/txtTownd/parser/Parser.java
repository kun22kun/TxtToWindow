/* 
 * 创建  骞坤 2014年5月10日  16:20
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
 * 解析TXT中的字段值并以HashMap类型返回
 */

public class Parser {
	/**
	 * 值验证画布的行值
	 */
	public static final int ROW_IN_CANVAS = 25;
	/**
	 * 值验证画布的列值
	 */
	public static final int COLUMN_IN_CANVAS = 4;
	
	/**
	 * 读入给定路径下文件，以HashMap<String,String>格式返回所有配置信息
	 * @param fileInParser
	 * @return configsMapRe
	 * @throws ContentException 
	 */
	public static HashMap<String, String> readerIn(File fileInParser) throws ContentException {

		//以String类型读入路径下文件内容
		String stringFromFile = Importer.importTXT(fileInParser);
		//System.out.println(stringFromFile);
		
		//将第一行先提出
		String[] strDivToFirCon = StringUtils.split(stringFromFile, "\n", 2);
		
		System.out.println(strDivToFirCon[1]);
		
		//对配置信息进行提取和验证
		ArrayList<Configuration> listTmp = stringToParse(strDivToFirCon[1]);

		HashMap<String, String> configsMapRe = Pack.changeLiToMa(listTmp);
		
		//将第一行加入到HashMap中
		configsMapRe.put("control.conf", strDivToFirCon[0]);

		return configsMapRe;
	}
	
	/**
	 * 读入字符串类型配置信息，以HashMap<String,String>格式返回所有配置信息
	 * @param stringFromStr
	 * @return configsMapRe
	 * @throws ContentException 
	 */
	public static HashMap<String, String> readerIn(String stringFromStr) throws ContentException {

		
		//System.out.println(stringFromStr);
		//将第一行先提出
		String[] strDivToFirCon = StringUtils.split(stringFromStr, "\n", 2);
		
		//对配置信息进行提取和验证
		ArrayList<Configuration> listTmp = stringToParse(strDivToFirCon[1]);

		HashMap<String, String> configsMapRe = Pack.changeLiToMa(listTmp);
		
		//将第一行加入到HashMap中
		configsMapRe.put("control.conf", strDivToFirCon[0]);

		return configsMapRe;
	}
	
	/**
	 * 读入字符串格式配置信息，返回ArrayList<Configuration>格式配置信息
	 * @param stringInput
	 * @return ConfigsList
	 * @throws ContentException 
	 */
	public static ArrayList<Configuration> stringToParse(String stringInput) throws ContentException {		

		// 第一步：检验字段间格式及关键词是否正确
		boolean isBtwFlds = Validator.isBetweenFields(stringInput);
		
		ArrayList<Configuration> ConfigsList = new ArrayList<Configuration>();
		
		if (!isBtwFlds){
//			System.out.println("输入格式出错，请检查后重新输入！");
			throw new ContentException("输入格式出错，请检查后重新输入！");
		}
		else {
			System.out.println("*************格式验证结果为：*************:\n" + isBtwFlds + "\n");

			// 第二步：将String分隔为以字段为单位元素的数组
			String[] fieldInParser = Splitter.splitToField(stringInput);
			int len = fieldInParser.length;

			// 第三步：通过“：”将字段分成两段，并取出每一段的值
			String fieldSp[][] = new String[len][];
			
			//用于值验证的Boolean型画布
			boolean [][] canvasToparse = new boolean[ROW_IN_CANVAS][COLUMN_IN_CANVAS];
			

			for (int num = 0; num < len; num++) {

				// 冒号分隔成两段
				// 将Spec字段赋值给Configuration类的spec成员变量 
				Configuration configTemp = new Configuration();
				fieldSp[num] = Splitter.fieldSplitByColon(fieldInParser[num]);
				configTemp.setSpec(fieldSp[num][1]);
				
				// 取出行列宽高值
				String numsInField = fieldSp[num][0];
				String[] valuesOfField = Splitter.fieldValues(numsInField);

				// 第四步：检验输入的行列宽高值是否合法
				System.out.println("***************增加第"+(num+1)+"个控件后画布情况******************");
				boolean isInFld = Validator.isInField(valuesOfField,canvasToparse,ROW_IN_CANVAS,COLUMN_IN_CANVAS);
				if (!isInFld) {					
					throw new ContentException("\n第" + (num+1) + "个控件数据存在问题！\n");
				} else {
					// 第五步：将值赋给Configuration类对应的成员变量
					configTemp.setH(Integer.valueOf(valuesOfField[1]) * 2 - 1);
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
