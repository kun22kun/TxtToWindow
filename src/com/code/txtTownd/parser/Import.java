package com.code.txtTownd.parser;

import java.io.*;


/**
 * @author 骞坤
 *	读入TXT
 */
public class Import {
	
		public static String importTXT(File file){			

			BufferedReader reader = null;
			StringBuilder readerString = new StringBuilder();
			try{
				System.out.println("*********读入TXT");
				reader = new BufferedReader(new FileReader(file));
				String temp = null;
				int line = 1;
				while ((temp = reader.readLine())!=null){
					//逐行输出
					readerString.append(temp);
					readerString.append(" ");
					System.out.println("line"+line+":"+temp);
					line++;
				}
				reader.close();
			}catch(IOException e){
				System.out.println("***********读入错误：");
				e.printStackTrace();
			}

			 return readerString.toString();
			 
		
	}

}
