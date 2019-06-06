package com.bt.appointment.dto;

import java.io.Serializable;

public class MessageInfo implements Serializable{
	
	public MessageInfo() {
		super();		
	}
	String CompletionCode;
	String Message;
	String Severity;
	public String getCompletionCode() {
		return CompletionCode;
	}
	public void setCompletionCode(String completionCode) {
		CompletionCode = completionCode;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public String getSeverity() {
		return Severity;
	}
	public void setSeverity(String severity) {
		Severity = severity;
	}
	@Override
	public String toString() {
		return "MessageInfo [CompletionCode=" + CompletionCode + ", Message=" + Message + ", Severity=" + Severity
				+ "]";
	}

}
