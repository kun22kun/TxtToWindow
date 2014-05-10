package com.code.txtTownd.parser;

import java.io.*;

/**
 * ����TXT����String�ͷ���
 *
 * @author ���
 */
public class Importer {
	/*
	 * ÿ�����ӻس��ַ���
	 */
	private static StringBuilder readerStringn = new StringBuilder();
	/*
	 * ÿ�����ӿո��ַ���
	 */
	private static StringBuilder readerStrings = new StringBuilder();

	public static String importTXT(File file) {

		BufferedReader reader = null;
		
		try {

			reader = new BufferedReader(new FileReader(file));
			String temp = null;

			// int line = 1;
			while ((temp = reader.readLine()) != null) {
				// ���ж��벢���ӵ�readerString��
				readerStringn.append(temp);
				readerStringn.append("\n");
				readerStrings.append(temp);
				readerStrings.append(" ");
				// System.out.println("line"+line+":"+temp);
				// line++;
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("***********�������");
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