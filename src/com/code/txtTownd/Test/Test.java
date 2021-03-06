 /*
  *  创建  骞坤 2014年5月16日 20:00
  */
package com.code.txttownd.test;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.code.txttownd.parser.*;
import com.code.txttownd.validator.ContentException;
/**
 *
 * 入口类
 * 
 */

public class Test {	
	
	
	public static void main(String[] args) {
		
		//提供两种输入方式：
		//1、给定路径下一个配置文件，获取以HashMap<String, String 格式的输入信息
		File configuresInput = new File("E:\\Aero\\Test.txt");
		
		//2、给定一段字符串配置信息，获取以HashMap<String,String>格式的输入信息		
		/*String configuresInput = getString(stringInSql);*/   //从数据库获取配置信息字符串的方法
		 
		
		// HashMap格式如下：
		//  Key（String类型）为Spec字段
		//  Value（String类型）依次为行列宽高值
		LinkedHashMap<String, String> configurationsInMap = new LinkedHashMap<>();
		try {
			configurationsInMap = Parser.readerIn(configuresInput);
		} catch (ContentException e) {
			e.printStackTrace();
		}
		int row = Parser.getRowMax();
		
		System.out.println("***************布局行数为：***************\n"+row+"\n");
		System.out.println("***************控件数量为：***************\n"+(configurationsInMap.size()-1)+"\n");	
		

		System.out.println("***************配置信息为：***************");
		Iterator<Entry<String, String>> iter = configurationsInMap.entrySet().iterator();	//用于测试读入到HashMap中的值是否正确
		while(iter.hasNext()){
			
			Map.Entry entry = (Map.Entry)iter.next();			
			String numsTemp = (String) entry.getValue();			
			System.out.println("Spec字段为："+entry.getKey()+"\t配置值为："+numsTemp);
			
			System.out.println();
		}
	}
	
}
