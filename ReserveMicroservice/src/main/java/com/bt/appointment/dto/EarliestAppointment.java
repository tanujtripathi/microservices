package com.bt.appointment.dto;

public class EarliestAppointment {

	public EarliestAppointment() {
		// TODO Auto-generated constructor stub
	}
	String AppointmentDate;
	String AppointmentTimeslot;
	public String getAppointmentDate() {
		return AppointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		AppointmentDate = appointmentDate;
	}
	public String getAppointmentTimeslot() {
		return AppointmentTimeslot;
	}
	public void setAppointmentTimeslot(String appointmentTimeslot) {
		AppointmentTimeslot = appointmentTimeslot;
	}

}
