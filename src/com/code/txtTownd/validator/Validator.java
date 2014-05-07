package com.code.txtTownd.validator;

/**
 * @author 骞坤
 *	验证TXT输入是否合法，包括以下：
 *		字段内：
 *			1、行列值是否属于可行域
 *			2、控件不能超出范围：numL+numK<5
 *			3、同一行内不可重叠：numL1+numK1<numL2&&numL1<numL2	
 *		字段间：
 *			1、字段间以一个或多个空格分隔
 *			2、第一行留为空白
 */
public class Validator {
	
	public static boolean valid(){
		
		
		return true;		
	}
	
	//验证输入是否在可行域内
	public boolean isInRange(){
		
		
		return true;
	}
	
	//验证输入是否超出范围
	public boolean isInFrame(){
		
		return true;
	}
	
	//验证控件之间是否重叠
	public boolean isNoOverlap(){
		
		return true;
	}
	
	//验证字段间空格
	public boolean isSpace(){
		
		return true;
	}
	
	//验证第一行是否留为空白
	public boolean isFirstLineBlank(){
		
		return true;
	}

}
