/*
 * ����  ��� 2014��5��14�� 16:20
 */
package com.code.txttownd.validator;

import java.util.regex.*;

/**
 *  
 *	��֤TXT�����Ƿ�Ϸ����������£�<br/>
 *		<li><b>�ֶ��ڣ�</b><br/></li>&emsp;
 *			1�����п��ֵ�Ƿ����ڿ�������ֵ����ֵȡ����������ֵ����ֵȡ��{1,2,3,4}<br/>&emsp;
 *			2���ؼ����ܳ�����Χ��numL + numK < 5<br/>&emsp;
 *			3��ͬһ���ڲ����ص���numL1 + numK1 < numL2 && numL1 < numL2 <br/>&emsp;
 *		<li><b>�ֶμ䣺</b><br/></li>&emsp;
 *			1���ֶμ���һ�������ո�ָ�<br/>&emsp;
 *			2����һ����Ϊ�հ�<br/>
 *
 */
public class Validator {	
	
	/**
	 * ��֤�ֶ����Ƿ�Ϸ�<br/>&emsp;
	 * 	1�����п��ֵ�Ƿ����ڿ�������ֵ����ֵȡ����������ֵ����ֵȡ��{1,2,3,4}<br/>&emsp;
	 * 	2���ؼ����ܳ�����Χ��numL + numK < 5<br/>&emsp;
	 * 	3��ͬһ���ڲ����ص���numL1 + numK1 < numL2 && numL1 < numL2<br/>
	 * @return boolean
	 */
	public static boolean isInField(String[] strToValid, boolean[][] canvas, int row , int column){	
		//TODO
		int ha = Integer.valueOf(strToValid[1]);
		int li = Integer.valueOf(strToValid[3]);
		int ku = Integer.valueOf(strToValid[5]);
		int ga = Integer.valueOf(strToValid[7]);
		
		//��ֵ����ֵȡ��{1,2,3,4},��ֵ�ӿ�ֵ�����ڱ��
		if(li<1||li>column||ku<1||ku>column
				||li+ku-1>column){
			System.out.println("��ֵ����ֵ����ֵ���ֵ֮������");
			return false;
		}
		
		//��⵱ǰ�ؼ�����ռ�ݵĿؼ��Ƿ��ѱ�ռ��
		// �����ռ�ã�����false
		// ���δ��ռ�ã�����ռ�������Ӧ��canvasԪ����Ϊtrue
		for(int i = ha-1; i < ha - 1 + ga; i ++){
			for(int j = li-1; j < li - 1 + ku; j++){
				if(canvas[i][j]){					
					System.out.println("�ؼ���֮ǰ�ؼ��ص���");
					return  false;					
				}
				canvas[i][j] = true;				 
			}
		}
		System.out.println();
		int rowInFor = (ha+ga-1)>4?ha+ga-1:4;
//		int rowInFor = Math.max(4, ha+ga-1);
		for(int i = 0; i < rowInFor; i++){
			for (int j = 0; j < column; j ++){
				System.out.print(canvas[i][j]+ "\t");
			}
			System.out.println();
		}
		System.out.println();
		return true;
	}	
	
	
	/**
	 * ��֤�ֶμ��ʽ<br/>&emsp;
	 * 1����һ�����հ�<br/>&emsp;
	 * 2���ֶμ��Կո��Ʊ�λ���еȷָ�<br/>
	 * @return boolean
	 */
	public static boolean isBetweenFields(String strToMatch){
		
		 // ����������ʽ��<br/>
		 // 	\s*\n ��֤��һ�пհ���
		 // 	\\H[1-9]\\d*L[1-9]\\d*K[1-9]\\d*G[1-9]\\d*:[A-Za-z]\\w* ��֤�ֶθ�ʽ
		 // 	\\s+ ��֤�Ƿ��ÿո��Ʊ�����еȣ��հ��ַ�������		 
		Pattern p = Pattern.compile
				("(H[1-9]\\d*L[1-9]\\d*K[1-9]\\d*G[1-9]\\d*:[A-Za-z]\\w*\\s+)+");
				
		Matcher m = p.matcher(strToMatch);
		boolean b = m.matches();
		return b;
	}

}
