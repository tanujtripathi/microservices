package com.appointing.reserve.dto;

import com.appointing.list.dto.RequestLineMessageInfo;

public class ReserveAppointmentResponse {

	public ReserveAppointmentResponse() {
		// TODO Auto-generated constructor stub
	}
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	public RequestLineMessageInfo getRequestLineMessageInfo() {
		return requestLineMessageInfo;
	}
	public void setRequestLineMessageInfo(RequestLineMessageInfo requestLineMessageInfo) {
		this.requestLineMessageInfo = requestLineMessageInfo;
	}
	Appointment appointment=new Appointment();
	RequestLineMessageInfo requestLineMessageInfo=new RequestLineMessageInfo();

}
