package com.code.txttownd.test;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.code.txttownd.parser.*;
/** 
 * @author 骞坤</br></br>
 *
 * 入口类
 * 
 */

public class Test {	
	
	
	public static void main(String[] args) {
		
		//给定路径下一个配置文件，获取以HashMap<String, Integer[]> 格式的输入信息
		File fileInTest = new File("E:\\Aero\\Test.txt");
		
		// 以HashMap格式如下：
		//  Key（String类型）为Spec字段
		//  Value（int[]类型）依次为行列宽高值
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
