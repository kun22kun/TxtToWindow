/*
 * @author ���<br/>
 */
package com.code.txttownd.validator;

import java.util.regex.*;

/**
 *  
 *	��֤TXT�����Ƿ�Ϸ����������£�<br/>
 *		<li><b>�ֶ��ڣ�</b><br/></li>&emsp;
 *			1�����п��ֵ�Ƿ����ڿ�������ֵ����ֵȡ����������ֵ����ֵȡ��{1,2,3,4}<br/>&emsp;
 *			2���ؼ����ܳ�����Χ��numL + numK < 5<br/>&emsp;
 *			3��ͬһ���ڲ����ص���numL1 + numK1 < numL2 && numL1 < numL2 <br/>&emsp;
 *		<li><b>�ֶμ䣺</b><br/></li>&emsp;
 *			1���ֶμ���һ�������ո�ָ�<br/>&emsp;
 *			2����һ����Ϊ�հ�<br/>
 *
 */
public class Validator {	
	
	/**
	 * ��֤�ֶ����Ƿ�Ϸ�<br/>&emsp;
	 * 	1�����п��ֵ�Ƿ����ڿ�������ֵ����ֵȡ����������ֵ����ֵȡ��{1,2,3,4}<br/>&emsp;
	 * 	2���ؼ����ܳ�����Χ��numL + numK < 5<br/>&emsp;
	 * 	3��ͬһ���ڲ����ص���numL1 + numK1 < numL2 && numL1 < numL2<br/>
	 * @return boolean
	 */
	public static boolean isInField(String[] strToValid){	
		
		return true;
	}	
	
	
	/**
	 * ��֤�ֶμ��ʽ<br/>&emsp;
	 * 1����һ�����հ�<br/>&emsp;
	 * 2���ֶμ��Կո��Ʊ�λ���еȷָ�<br/>
	 * @return boolean
	 */
	public static boolean isBetweenFields(String strToMatch){
		
		 // ����������ʽ��<br/>
		 // 	\s*\n ��֤��һ�пհ���
		 // 	\\H[1-9]\\d*L[1-4]K[1-4]G[1-9]\\d*:[A-Za-z]\\w* ��֤�ֶθ�ʽ
		 // 	\\s+ ��֤�Ƿ��ÿո��Ʊ�����еȣ��հ��ַ�������		 
		Pattern p = Pattern.compile
				("^\\s*\\n[H[1-9]\\d*L[1-4]K[1-4]G[1-9]\\d*:[A-Za-z]\\w*\\s+]+$");
		Matcher m = p.matcher(strToMatch);
		boolean b = m.matches();
		return b;
	}

}
