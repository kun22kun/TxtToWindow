 /*
  * @author ���
  */
package com.code.txttownd.pack;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;

import com.code.txttownd.config.Configuration;

/**
 * ��ArrayList<Configuration>��ʽ�������ݷ�װ��������ʽ
 */
public class Pack {
	
	/**
	 * ��������Ϣ��ArrayList<Configuration>����ת��HashMap<String,String>����
	 * @param listToMap
	 * @return mapFromList
	 */
	public static HashMap<String, String> changeLiToMa(ArrayList<Configuration> listToMap) {
		
		HashMap<String, String> mapFromList = new HashMap<>();
		
		for(int i = 0; i < listToMap.size(); i++){
			
			//��List��spec�ֶθ�ֵ��Map�е�Key
			String specInMap = listToMap.get(i).getSpec();			
			
			Integer[] intInMap = new Integer[4];			
			intInMap[0] = listToMap.get(i).getH();
			intInMap[1] = listToMap.get(i).getL();
			intInMap[2] = listToMap.get(i).getK();
			intInMap[3] = listToMap.get(i).getG();
			
			//��List�������������ݸ�ֵ��Map�е�Value��עValueΪString����
			String numsInMap = StringUtils.join(intInMap,",");
			
			//��HashMap�����Ԫ��
			mapFromList.put(specInMap, numsInMap);
		}		

		return mapFromList;
	}

}
