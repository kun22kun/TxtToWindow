package com.code.txtTownd.parser;

import java.io.*;

/**
 * @author ���
 * 
 * 	����TXT�е��ֶ�ֵ
 *
 */
public class Parser {
	
	public static void ReaderIn(){
		
		
		File fileInParser = new File("E:\\Aero\\Test.txt");
		String readerInParser = Import.importTXT(fileInParser);
		
		System.out.println(readerInParser);
			
		
	}	

}

