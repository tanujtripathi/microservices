package com.bt.appointment.dto;

import java.io.Serializable;

public class RequestLineMessageInfo implements Serializable {

	public RequestLineMessageInfo() {
		super();		
	}

	MessageInfo messageInfo = new MessageInfo() ;

	public MessageInfo getMessageInfo() {
		return messageInfo;
	}

	public void setMessageInfo(MessageInfo messageInfo) {
		this.messageInfo = messageInfo;
	}

	@Override
	public String toString() {
		return "RequestLineMessageInfo [messageInfo=" + messageInfo + "]";
	}
	
}
