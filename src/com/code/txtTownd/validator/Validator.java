package com.code.txtTownd.validator;

import java.util.regex.*;

/**
 *	验证TXT输入是否合法，包括以下：
 *		字段内：
 *			1、行列值是否属于可行域
 *			2、控件不能超出范围：numL+numK<5
 *			3、同一行内不可重叠：numL1+numK1<numL2&&numL1<numL2	
 *		字段间：
 *			1、字段间以一个或多个空格分隔
 *			2、第一行留为空白
 *
 *@author 骞坤
 */
public class Validator {
	
	public static boolean valid(){
		
		
		return true;		
	}
	
	/**
	 * 验证输入是否在可行域内
	 * 1、行值高值为：整形，且大于0
	 * 2、列值宽值取自{1,2,3,4}
	 */
	public static boolean isInRange(){
		
		
		return true;
	}
	
	/**
	 * 验证输入是否超出范围
	 * @return
	 */
	public static boolean isInFrame(){
		
		return true;
	}
	
	/**
	 * 验证控件之间是否重叠
	 * @return
	 */
	public static boolean isNoOverlap(){
		
		return true;
	}
	
	/**
	 * 验证字段间格式
	 * 1、第一行留空白
	 * 2、字段间以空格、制表位或换行等分隔
	 * @return
	 */
	public static boolean isBetweenFields(String strToMatch){		
		/*
		 * 定义正则表达式：
		 *  \s*\n 验证第一行空白行
		 *  \\H[1-9]\\d*L[1-4]K[1-4]G[1-9]\\d*:[A-Za-z]\\w* 验证字段格式
		 *  \\s+ 验证是否用空格、制表符或换行等（空白字符）隔开
		 */
		Pattern p = Pattern.compile
				("^\\s*\\n[H[1-9]\\d*L[1-4]K[1-4]G[1-9]\\d*:[A-Za-z]\\w*\\s+]+$");
		Matcher m = p.matcher(strToMatch);
		boolean b = m.matches();
		return b;
	}

}
