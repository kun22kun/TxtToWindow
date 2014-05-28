package com.code.txttownd.validator;

import java.lang.instrument.IllegalClassFormatException;

public class ContentException extends IllegalClassFormatException {
	
	public ContentException(String msg){
		
		System.out.println(msg);
		
	}

}
