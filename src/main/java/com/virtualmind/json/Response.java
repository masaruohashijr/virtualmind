package com.virtualmind.json;

import java.io.Serializable;

/**
 * @author Masaru Ohashi Júnior
 */
public class Response implements Serializable {

	private static final long serialVersionUID = 1L;

	private Object returnObject;
	
	private String returnMessages;
	
	public Object getReturnObject() {
		return returnObject;
	}
	public void setReturnObject(Object returnObject) {
		this.returnObject = returnObject;
	}
	public String getReturnMessages() {
		return returnMessages;
	}
	public void setReturnMessages(String returnMessages) {
		this.returnMessages = returnMessages;
	}

}
