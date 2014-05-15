package com.code.txttownd.parser;

import java.io.*;

/**
 * @author 骞坤</br></br>
 * 
 * 读入TXT并以String型返回
 *
 */
public class Importer {
	
	/**
	 * 以回车分隔的输入字符串
	 */
	private static StringBuilder readerStringn = new StringBuilder();
	/**
	 * 以空格分隔的输入字符串
	 */
	private static StringBuilder readerStrings = new StringBuilder();

	public static String importTXT(File file) {

		BufferedReader reader = null;
		
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
	
	public static StringBuilder getReaderStringn() {
		return readerStringn;
	}

	public static StringBuilder getReaderStrings() {
		return readerStrings;
	}



}
