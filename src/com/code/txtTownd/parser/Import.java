package com.code.txtTownd.parser;

import java.io.*;


/**
 * @author ���
 *	����TXT
 */
public class Import {
	
		public static String importTXT(File file){			

			BufferedReader reader = null;
			StringBuilder readerString = new StringBuilder();
			try{
				System.out.println("*********����TXT");
				reader = new BufferedReader(new FileReader(file));
				String temp = null;
				int line = 1;
				while ((temp = reader.readLine())!=null){
					//�������
					readerString.append(temp);
					readerString.append(" ");
					System.out.println("line"+line+":"+temp);
					line++;
				}
				reader.close();
			}catch(IOException e){
				System.out.println("***********�������");
				e.printStackTrace();
			}

			 return readerString.toString();
			 
		
	}

}
