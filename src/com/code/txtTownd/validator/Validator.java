package com.code.txtTownd.validator;

import java.util.regex.*;

/**
 *	��֤TXT�����Ƿ�Ϸ����������£�
 *		�ֶ��ڣ�
 *			1������ֵ�Ƿ����ڿ�����
 *			2���ؼ����ܳ�����Χ��numL+numK<5
 *			3��ͬһ���ڲ����ص���numL1+numK1<numL2&&numL1<numL2	
 *		�ֶμ䣺
 *			1���ֶμ���һ�������ո�ָ�
 *			2����һ����Ϊ�հ�
 *
 *@author ���
 */
public class Validator {
	
	public static boolean valid(){
		
		
		return true;		
	}
	
	/**
	 * ��֤�����Ƿ��ڿ�������
	 * 1����ֵ��ֵΪ�����Σ��Ҵ���0
	 * 2����ֵ��ֵȡ��{1,2,3,4}
	 */
	public static boolean isInRange(){
		
		
		return true;
	}
	
	/**
	 * ��֤�����Ƿ񳬳���Χ
	 * @return
	 */
	public static boolean isInFrame(){
		
		return true;
	}
	
	/**
	 * ��֤�ؼ�֮���Ƿ��ص�
	 * @return
	 */
	public static boolean isNoOverlap(){
		
		return true;
	}
	
	/**
	 * ��֤�ֶμ��ʽ
	 * 1����һ�����հ�
	 * 2���ֶμ��Կո��Ʊ�λ���еȷָ�
	 * @return
	 */
	public static boolean isBetweenFields(String strToMatch){		
		/*
		 * ����������ʽ��
		 *  \s*\n ��֤��һ�пհ���
		 *  \\H[1-9]\\d*L[1-4]K[1-4]G[1-9]\\d*:[A-Za-z]\\w* ��֤�ֶθ�ʽ
		 *  \\s+ ��֤�Ƿ��ÿո��Ʊ�����еȣ��հ��ַ�������
		 */
		Pattern p = Pattern.compile
				("^\\s*\\n[H[1-9]\\d*L[1-4]K[1-4]G[1-9]\\d*:[A-Za-z]\\w*\\s+]+$");
		Matcher m = p.matcher(strToMatch);
		boolean b = m.matches();
		return b;
	}

}
