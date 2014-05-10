package com.code.txtTownd.parser;

import org.apache.commons.lang3.StringUtils;

/** 
 *	1�������ص�String�ָ�Ϊ�Կؼ��ֶ�Ϊ��λ��String����
 *	2�����ֶ���ð�ŷָ�
 *	3��ȡ������ֵ
 *
 ** @author ���
 */
public class Splitter {
	
	/**
	 * �����ص�String�ָ�Ϊ���ֶ�
	 */
	public static String[] splitToField(String str){
		
		String[] fieldString = StringUtils.split(str);
		
		return fieldString;
		
	}
	
	/**
	 * ���ֶ���ð�ŷָ�Ϊ����
	 */
	public static String[] fieldSplitByColon(String str){
		
		String[] fieldSptByCol = StringUtils.split(str, ":");
		
		return fieldSptByCol;		
	}
	/**
	 * ��ǰ����ֶ�ֵȡ��
	 */
	public static String[] fieldValues(String foreFld){
		
		String[] valueFld = StringUtils.splitByCharacterType(foreFld);
		
		return valueFld;
		
	}

}
