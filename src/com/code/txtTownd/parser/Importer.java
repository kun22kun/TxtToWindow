/*
 * @author 骞坤
 */
package com.code.txttownd.parser;

import java.io.*;

/**
 *  
 * 读入TXT并以String型返回
 *
 */
public class Importer {	
	
	/**
	 * 读入指定路径下配置文件
	 * @param file
	 * @return readerStringn.toString()
	 */
	public static String importTXT(File file) {

		BufferedReader reader = null;
		StringBuilder readerStrings = new StringBuilder();
		//以回车分隔的输入字符串
		StringBuilder readerStringn = new StringBuilder();
		try {
			
			reader = new BufferedReader(new FileReader(file));
			String temp = null;

			// int line = 1;
			while ((temp = reader.readLine()) != null) {
				
				// 逐行读入并添加到readerString后
				readerStringn.append(temp);
				readerStringn.append("\n");
				
				readerStrings.append(temp);
				readerStrings.append(" ");
				// System.out.println("line"+line+":"+temp);
				// line++;
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("***********读入错误：");
			e.printStackTrace();
		}

		return readerStringn.toString();

	}

}
