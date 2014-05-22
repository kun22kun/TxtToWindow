 /*
  * @author 骞坤
  */
package com.code.txttownd.pack;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;

import com.code.txttownd.config.Configuration;

/**
 * 将ArrayList<Configuration>格式输入数据封装成其他格式
 */
public class Pack {
	
	/**
	 * 将配置信息从ArrayList<Configuration>类型转到HashMap<String,String>类型
	 * @param listToMap
	 * @return mapFromList
	 */
	public static HashMap<String, String> changeLiToMa(ArrayList<Configuration> listToMap) {
		
		HashMap<String, String> mapFromList = new HashMap<>();
		
		for(int i = 0; i < listToMap.size(); i++){
			
			//将List中spec字段赋值给Map中的Key
			String specInMap = listToMap.get(i).getSpec();			
			
			Integer[] intInMap = new Integer[4];			
			intInMap[0] = listToMap.get(i).getH();
			intInMap[1] = listToMap.get(i).getL();
			intInMap[2] = listToMap.get(i).getK();
			intInMap[3] = listToMap.get(i).getG();
			
			//将List中其他配置数据赋值给Map中的Value，注Value为String类型
			String numsInMap = StringUtils.join(intInMap,",");
			
			//向HashMap中添加元素
			mapFromList.put(specInMap, numsInMap);
		}		

		return mapFromList;
	}

}
