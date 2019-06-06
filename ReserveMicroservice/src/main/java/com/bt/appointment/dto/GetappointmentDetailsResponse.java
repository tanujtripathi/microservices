package com.bt.appointment.dto;

import java.io.Serializable;
import java.util.ArrayList;


public class GetappointmentDetailsResponse implements Serializable {
	
	 public GetappointmentDetailsResponse() {
		super();
		}
	 Appointment  Appointment =  new Appointment();
	 RequestLineMessageInfo requestLineMessageInfo = new RequestLineMessageInfo();
	public Appointment getAppointment() {
		return Appointment;
	}
	public void setAppointment(Appointment appointment) {
		Appointment = appointment;
	}
	public RequestLineMessageInfo getRequestLineMessageInfo() {
		return requestLineMessageInfo;
	}
	public void setRequestLineMessageInfo(
			RequestLineMessageInfo requestLineMessageInfo) {
		this.requestLineMessageInfo = requestLineMessageInfo;
	}
	
	 

}
