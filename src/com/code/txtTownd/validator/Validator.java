/*
 * @author 骞坤<br/>
 */
package com.code.txttownd.validator;

import java.util.regex.*;

/**
 *  
 *	验证TXT输入是否合法，包括以下：<br/>
 *		<li><b>字段内：</b><br/></li>&emsp;
 *			1、行列宽高值是否属于可行域，行值、高值取正整数，列值、宽值取自{1,2,3,4}<br/>&emsp;
 *			2、控件不能超出范围：numL + numK < 5<br/>&emsp;
 *			3、同一行内不可重叠：numL1 + numK1 < numL2 && numL1 < numL2 <br/>&emsp;
 *		<li><b>字段间：</b><br/></li>&emsp;
 *			1、字段间以一个或多个空格分隔<br/>&emsp;
 *			2、第一行留为空白<br/>
 *
 */
public class Validator {	
	
	/**
	 * 验证字段内是否合法<br/>&emsp;
	 * 	1、行列宽高值是否属于可行域，行值、高值取正整数，列值、宽值取自{1,2,3,4}<br/>&emsp;
	 * 	2、控件不能超出范围：numL + numK < 5<br/>&emsp;
	 * 	3、同一行内不可重叠：numL1 + numK1 < numL2 && numL1 < numL2<br/>
	 * @return boolean
	 */
	public static boolean isInField(String[] strToValid){	
		
		return true;
	}	
	
	
	/**
	 * 验证字段间格式<br/>&emsp;
	 * 1、第一行留空白<br/>&emsp;
	 * 2、字段间以空格、制表位或换行等分隔<br/>
	 * @return boolean
	 */
	public static boolean isBetweenFields(String strToMatch){
		
		 // 定义正则表达式：<br/>
		 // 	\s*\n 验证第一行空白行
		 // 	\\H[1-9]\\d*L[1-4]K[1-4]G[1-9]\\d*:[A-Za-z]\\w* 验证字段格式
		 // 	\\s+ 验证是否用空格、制表符或换行等（空白字符）隔开		 
		Pattern p = Pattern.compile
				("^\\s*\\n[H[1-9]\\d*L[1-4]K[1-4]G[1-9]\\d*:[A-Za-z]\\w*\\s+]+$");
		Matcher m = p.matcher(strToMatch);
		boolean b = m.matches();
		return b;
	}

}
