package com.code.txttownd.test;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.code.txttownd.parser.*;


public class Test {	
	
	
	public static void main(String[] args) {
		
		
		File fileInTest = new File("E:\\Aero\\Test.txt");
		HashMap<String, Integer[]> configurationsInMap = Parser.ReaderIn(fileInTest);
		

		
/*		Iterator iter = configurationsInMap.entrySet().iterator();	//用于测试读入到HashMap中的值是否正确
		while(iter.hasNext()){
			Map.Entry entry = (Map.Entry)iter.next();
			System.out.println("Spec字段为："+entry.getKey());
			Integer[] intTemp = (Integer[]) entry.getValue();
			for(int i=0;i<4;i++){
				System.out.print("第"+i+"个值为："+intTemp[i]+" ");
			}
			System.out.println();
			System.out.println();
		}*/
	}
	
		

}
