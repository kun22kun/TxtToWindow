 /*
  *  @author ���</br></br>
  */
package com.code.txttownd.test;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

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
		/*String configuresInput = getString(stringInSql);*/   //�����ݿ��ȡ������Ϣ�ַ����ķ���
		 
		
		// HashMap��ʽ���£�
		//  Key��String���ͣ�ΪSpec�ֶ�
		//  Value��String���ͣ�����Ϊ���п��ֵ
		HashMap<String, String> configurationsInMap = Parser.readerIn(configuresInput);
		System.out.println("***************�ؼ�����Ϊ��***************\n"+configurationsInMap.size()+"\n");

		System.out.println("***************������ϢΪ��***************");
		Iterator<Entry<String, String>> iter = configurationsInMap.entrySet().iterator();	//���ڲ��Զ��뵽HashMap�е�ֵ�Ƿ���ȷ
		while(iter.hasNext()){
			
			Map.Entry entry = (Map.Entry)iter.next();			
			String numsTemp = (String) entry.getValue();			
			System.out.println("Spec�ֶ�Ϊ��"+entry.getKey()+"\t����ֵΪ��"+numsTemp);
			
			System.out.println();
		}
	}
	
}
