package com.appointing.get.dto;

import java.util.Date;

public class Appointment {
	private String RefNum; 
	private Date appointmentDate;
	private String appointmentTimeslot;
	private String serviceType;
	private String action;
	private String quantity;
	private String serviceLevel;
	private String appointmentType;
	EarliestAppointment earliestAppointment=new EarliestAppointment();

	public EarliestAppointment getEarliestAppointment() {
		return earliestAppointment;
	}

	public void setEarliestAppointment(EarliestAppointment earliestAppointment) {
		this.earliestAppointment = earliestAppointment;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getAppointmentTimeslot() {
		return appointmentTimeslot;
	}

	public void setAppointmentTimeslot(String appointmentTimeslot) {
		this.appointmentTimeslot = appointmentTimeslot;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getServiceLevel() {
		return serviceLevel;
	}

	public void setServiceLevel(String serviceLevel) {
		this.serviceLevel = serviceLevel;
	}

	public String getAppointmentType() {
		return appointmentType;
	}

	public void setAppointmentType(String appointmentType) {
		this.appointmentType = appointmentType;
	}

	@Override
	public String toString() {
		return "GetAppointmentResponse [appointmentDate=" + appointmentDate + ", appointmentTimeslot="
				+ appointmentTimeslot + ", serviceType=" + serviceType + ", action=" + action + ", quantity=" + quantity
				+ ", serviceLevel=" + serviceLevel + ", appointmentType=" + appointmentType + "]";
	}

}
