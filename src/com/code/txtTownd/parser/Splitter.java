package com.code.txttownd.parser;

import org.apache.commons.lang3.StringUtils;

/** 
 * @author ���<br/>
 * <br/>
 *	1�������ص�String�ָ�Ϊ�Կؼ��ֶ�Ϊ��λ��String����<br/>
 *	2�����ֶ���ð�ŷָ�<br/>
 *	3��ȡ������ֵ<br/>
 *
 */
public class Splitter {
	
	/**
	 * �Կհ׷�Ϊ�ָ�����String�ָ�Ϊ����ֶ�
	 * @return String[]
	 */
	public static String[] splitToField(String str){
		
		String[] fieldString = StringUtils.split(str);
		
		return fieldString;
		
	}
	
	/**
	 * ���ֶ���ð�ŷָ�Ϊ����
	 * @return String[]
	 */
	public static String[] fieldSplitByColon(String str){
		
		String[] fieldSptByCol = StringUtils.split(str, ":");
		
		return fieldSptByCol;		
	}
	/**
	 * ��ǰ����ֶ�ֵȡ��
	 * @return String[]
	 */
	public static String[] fieldValues(String foreFld){
		
		String[] valueFld = StringUtils.splitByCharacterType(foreFld);
		
		return valueFld;
		
	}

}
