package com.code.txttownd.parser;

import org.apache.commons.lang3.StringUtils;

/** 
 * @author 骞坤<br/>
 * <br/>
 *	1、将返回的String分隔为以控件字段为单位的String数组<br/>
 *	2、将字段以冒号分隔<br/>
 *	3、取出数据值<br/>
 *
 */
public class Splitter {
	
	/**
	 * 以空白符为分隔，将String分隔为多个字段
	 * @return String[]
	 */
	public static String[] splitToField(String str){
		
		String[] fieldString = StringUtils.split(str);
		
		return fieldString;
		
	}
	
	/**
	 * 将字段以冒号分隔为两段
	 * @return String[]
	 */
	public static String[] fieldSplitByColon(String str){
		
		String[] fieldSptByCol = StringUtils.split(str, ":");
		
		return fieldSptByCol;		
	}
	/**
	 * 将前半段字段值取出
	 * @return String[]
	 */
	public static String[] fieldValues(String foreFld){
		
		String[] valueFld = StringUtils.splitByCharacterType(foreFld);
		
		return valueFld;
		
	}

}
