 /*
  *  @author ���</br></br>
  */
package com.code.txttownd.test;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.code.txttownd.parser.*;
/**
 *
 * �����
 * 
 */

public class Test {	
	
	
	public static void main(String[] args) {
		
		//�ṩ�������뷽ʽ��
		//1������·����һ�������ļ�����ȡ��HashMap<String, String ��ʽ��������Ϣ
		File configuresInput = new File("E:\\Aero\\Test.txt");
		
		//2������һ���ַ���������Ϣ����ȡ��HashMap<String,String>��ʽ��������Ϣ		
		/*
		 * String configuresInput = getString(stringInSql);
		 */
		
		// ��HashMap��ʽ���£�
		//  Key��String���ͣ�ΪSpec�ֶ�
		//  Value��int[]���ͣ�����Ϊ���п��ֵ
		HashMap<String, Integer[]> configurationsInMap = Parser.ReaderIn(configuresInput);
		System.out.println(configurationsInMap.size());

		
		Iterator iter = configurationsInMap.entrySet().iterator();	//���ڲ��Զ��뵽HashMap�е�ֵ�Ƿ���ȷ
		while(iter.hasNext()){
			Map.Entry entry = (Map.Entry)iter.next();
			System.out.println("Spec�ֶ�Ϊ��"+entry.getKey());
			Integer[] intTemp = (Integer[]) entry.getValue();
			for(int i=0;i<4;i++){
				System.out.print("��"+i+"��ֵΪ��"+intTemp[i]+" ");
			}
			System.out.println();
			System.out.println();
		}
	}
	
		

}
