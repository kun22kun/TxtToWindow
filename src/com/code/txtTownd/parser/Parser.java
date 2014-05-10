package com.code.txtTownd.parser;

import java.awt.List;
import java.io.*;
import java.util.ArrayList;

import com.code.txtTownd.config.Configuration;
import com.code.txtTownd.validator.Validator;

/**
 * 
 * 	解析TXT中的字段值
 *
 * @author 骞坤
 */

public class Parser {
	
	/**
	 * 存储读入的内容
	 **/
	private static String readerInParser = null;
	/**
	 * 存储Configuration信息列表
	 */
	private static ArrayList<Configuration> ConfigS = new ArrayList<>();

	
	public static void ReaderIn(){
		
		/*
		 * 第一步：读入TXT转化为String型
		 */
		File fileInParser = new File("E:\\Aero\\Test.txt");
		readerInParser = Importer.importTXT(fileInParser);
//		System.out.println(readerInParser);
		
		/*
		 * 第二步：检验字段间格式
		 */
		boolean isBtwFlds = Validator.isBetweenFields(readerInParser);
		System.out.println("************检测结果为："+isBtwFlds);
		
		 /*
		  * 第三步：将String分隔为字段构成的数组
		  */
		String[] fieldInParser = Splitter.splitToField(readerInParser);		
		int len = fieldInParser.length;
		
		 /*
		  * 第四步：通过“：”将字段分成两段，并取出每一段的值
		  */
		String fieldSp[][] = new String[len][];
		
		for(int num=0;num<len;num++){
			
			//冒号分隔成两段并赋值Spec字段给Configuration类
			Configuration configTemp = new Configuration();
			fieldSp[num] = Splitter.fieldSplitByColon(fieldInParser[num]);
			configTemp.setSpec(fieldSp[num][1]);
			
			//取出方位宽高值
			String foreField = fieldSp[num][0];
			String[] valueField = Splitter.fieldValues(foreField);	
			
			
			//将值赋给Configuration类对应的成员变量			
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

