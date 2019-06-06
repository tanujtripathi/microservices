package com.bt.appointment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Appointment")
public class Appointment {
	
	@Id
	private String app_refId;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "am_pm")
	private String am_pm;
	
	@Column(name = "status")
	private boolean status;

	
	public String getApp_refId() {
		return app_refId;
	}

	public void setApp_refId(String app_refId) {
		this.app_refId = app_refId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAm_pm() {
		return am_pm;
	}

	public void setAm_pm(String am_pm) {
		this.am_pm = am_pm;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
