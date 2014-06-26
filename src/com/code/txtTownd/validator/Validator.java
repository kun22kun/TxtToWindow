/*
 * 创建  骞坤 2014年5月14日 16:20
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
	public static boolean isInField(String[] strToValid, boolean[][] canvas, int row , int column){	
		//TODO
		int ha = Integer.valueOf(strToValid[1]);
		int li = Integer.valueOf(strToValid[3]);
		int ku = Integer.valueOf(strToValid[5]);
		int ga = Integer.valueOf(strToValid[7]);
		
		//列值，宽值取自{1,2,3,4},列值加宽值不大于表宽
		if(li<1||li>column||ku<1||ku>column
				||li+ku-1>column){
			System.out.println("列值，宽值或列值与宽值之和有误！");
			return false;
		}
		
		//检测当前控件所需占据的控件是否已被占用
		// 如果被占用，返回false
		// 如果未被占用，则将其占用区域对应的canvas元素置为true
		for(int i = ha-1; i < ha - 1 + ga; i ++){
			for(int j = li-1; j < li - 1 + ku; j++){
				if(canvas[i][j]){					
					System.out.println("控件与之前控件重叠！");
					return  false;					
				}
				canvas[i][j] = true;				 
			}
		}
		System.out.println();
		int rowInFor = (ha+ga-1)>4?ha+ga-1:4;
//		int rowInFor = Math.max(4, ha+ga-1);
		for(int i = 0; i < rowInFor; i++){
			for (int j = 0; j < column; j ++){
				System.out.print(canvas[i][j]+ "\t");
			}
			System.out.println();
		}
		System.out.println();
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
		 // 	\\H[1-9]\\d*L[1-9]\\d*K[1-9]\\d*G[1-9]\\d*:[A-Za-z]\\w* 验证字段格式
		 // 	\\s+ 验证是否用空格、制表符或换行等（空白字符）隔开		 
		Pattern p = Pattern.compile
				("(H[1-9]\\d*L[1-9]\\d*K[1-9]\\d*G[1-9]\\d*:[A-Za-z]\\w*\\s+)+");
				
		Matcher m = p.matcher(strToMatch);
		boolean b = m.matches();
		return b;
	}

}
