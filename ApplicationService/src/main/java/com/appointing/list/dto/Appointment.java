package com.appointing.list.dto;

import java.io.Serializable;

public class Appointment implements Serializable {
	
public Appointment() {
		super();		
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
@Override
public String toString() {
	return "Appointment [AppointmentDate=" + AppointmentDate + ", AppointmentTimeslot=" + AppointmentTimeslot + "]";
}
}
