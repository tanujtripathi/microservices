package com.bt.appointment.dto;

import java.io.Serializable;
import java.util.ArrayList;


public class ListAvailableAppointmentResponse implements Serializable {
	
	 public ListAvailableAppointmentResponse() {
		super();
		}
	ArrayList < Appointment > Appointment = new ArrayList < Appointment > ();
	 RequestLineMessageInfo requestLineMessageInfo = new RequestLineMessageInfo();
	public ArrayList<Appointment> getAppointment() {
		return Appointment;
	}
	public void setAppointment(ArrayList<Appointment> appointment) {
		Appointment = appointment;
	}
	public RequestLineMessageInfo getRequestLineMessageInfo() {
		return requestLineMessageInfo;
	}
	public void setRequestLineMessageInfo(RequestLineMessageInfo requestLineMessageInfo) {
		this.requestLineMessageInfo = requestLineMessageInfo;
	}
	 

}
