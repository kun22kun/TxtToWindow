package com.code.txttownd.test;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.code.txttownd.parser.*;
/** 
 * @author ���</br></br>
 *
 * �����
 * 
 */

public class Test {	
	
	
	public static void main(String[] args) {
		
		//����·����һ�������ļ�����ȡ��HashMap<String, Integer[]> ��ʽ��������Ϣ
		File fileInTest = new File("E:\\Aero\\Test.txt");
		
		// ��HashMap��ʽ���£�
		//  Key��String���ͣ�ΪSpec�ֶ�
		//  Value��int[]���ͣ�����Ϊ���п��ֵ
		HashMap<String, Integer[]> configurationsInMap = Parser.ReaderIn(fileInTest);
		

		
/*		Iterator iter = configurationsInMap.entrySet().iterator();	//���ڲ��Զ��뵽HashMap�е�ֵ�Ƿ���ȷ
		while(iter.hasNext()){
			Map.Entry entry = (Map.Entry)iter.next();
			System.out.println("Spec�ֶ�Ϊ��"+entry.getKey());
			Integer[] intTemp = (Integer[]) entry.getValue();
			for(int i=0;i<4;i++){
				System.out.print("��"+i+"��ֵΪ��"+intTemp[i]+" ");
			}
			System.out.println();
			System.out.println();
		}*/
	}
	
		

}
