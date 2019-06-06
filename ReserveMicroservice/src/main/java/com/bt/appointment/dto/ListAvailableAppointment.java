package com.bt.appointment.dto;

import java.io.Serializable;

public class ListAvailableAppointment implements Serializable{
	ListAvailableAppointmentResponse listAvailableAppointmentResponse = new ListAvailableAppointmentResponse();
public ListAvailableAppointment() {
	// TODO Auto-generated constructor stub
}
	public ListAvailableAppointmentResponse getListAvailableAppointmentResponse() {
		return listAvailableAppointmentResponse;
	}

	public void setListAvailableAppointmentResponse(ListAvailableAppointmentResponse listAvailableAppointmentResponse) {
		this.listAvailableAppointmentResponse = listAvailableAppointmentResponse;
	}
	

}
