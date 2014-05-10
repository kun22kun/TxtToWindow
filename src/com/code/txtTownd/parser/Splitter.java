package com.code.txtTownd.parser;

import org.apache.commons.lang3.StringUtils;

/** 
 *	1、将返回的String分隔为以控件字段为单位的String数组
 *	2、将字段以冒号分隔
 *	3、取出数据值
 *
 ** @author 骞坤
 */
public class Splitter {
	
	/**
	 * 将返回的String分隔为以字段
	 */
	public static String[] splitToField(String str){
		
		String[] fieldString = StringUtils.split(str);
		
		return fieldString;
		
	}
	
	/**
	 * 将字段以冒号分隔为两段
	 */
	public static String[] fieldSplitByColon(String str){
		
		String[] fieldSptByCol = StringUtils.split(str, ":");
		
		return fieldSptByCol;		
	}
	/**
	 * 将前半段字段值取出
	 */
	public static String[] fieldValues(String foreFld){
		
		String[] valueFld = StringUtils.splitByCharacterType(foreFld);
		
		return valueFld;
		
	}

}
