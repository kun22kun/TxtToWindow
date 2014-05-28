/*
 * ���� ��� 2014��5��12�� 9:42
 */
package com.code.txttownd.parser;

import java.io.*;

/**
 *  
 * ����TXT����String�ͷ���
 *
 */
public class Importer {	
	
	/**
	 * ����ָ��·���������ļ�
	 * @param file
	 * @return readerStringn.toString()
	 */
	public static String importTXT(File file) {

		BufferedReader reader = null;
		StringBuilder readerStrings = new StringBuilder();
		//�Իس��ָ��������ַ���
		StringBuilder readerStringn = new StringBuilder();
		try {
			
			reader = new BufferedReader(new FileReader(file));
			String temp = null;

			// int line = 1;
			while ((temp = reader.readLine()) != null) {//whileѭ�������һ���س���ո�
				
				// ���ж��벢��ӵ�readerString��
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

}
