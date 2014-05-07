package com.code.txtTownd.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


/**
 * @author Âπ¿§
 *	∂¡»ÎTXT
 */
public class Import {
	
		public static void importTXT(){
			
			File file = new File("E:\\Aero\\Test.txt");
			BufferedReader reader = null;
			try{
				System.out.println("*********∂¡»ÎTXT");
				reader = new BufferedReader(new FileReader(file));
				String temp = null;
				int line = 1;
				while ((temp = reader.readLine())!=null){
					//÷–– ‰≥ˆ
					System.out.println("line"+line+":"+temp);
					line++;
				}
				reader.close();
			}catch(IOException e){
				System.out.println("***********∂¡»Î¥ÌŒÛ£∫");
				e.printStackTrace();
			}finally{
				if(reader != null ){
					try{
						reader.close();
					}catch(IOException e1){
						e1.printStackTrace();
					}
				}
			}
		
	}

}
