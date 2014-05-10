package com.code.txtTownd.Test;
import java.util.ArrayList;
import com.code.txtTownd.config.Configuration;
import com.code.txtTownd.parser.*;

public class Test {
	
	public static void main(String[] args) {
		
		Parser.ReaderIn();
		
		ArrayList<Configuration> configurations	= Parser.getConfigS();
		
		
		
		for(int i = 0; i < configurations.size();i++){
			Configuration configTemp1 = (Configuration)configurations.get(i);
			System.out.print("行值"+configTemp1.getH()+"\t");
			System.out.print("列值"+configTemp1.getL()+"\t");
			System.out.print("宽值"+configTemp1.getK()+"\t");
			System.out.print("高值"+configTemp1.getG()+"\t");
			System.out.println("Spec段"+configTemp1.getSpec());
		}
		System.out.println();
	}

}
