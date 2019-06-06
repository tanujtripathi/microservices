package com.bt.esb;

import com.bt.esb.model.Appointment;

import java.util.Map;

public interface UserRepository {    	
	void save(Appointment appt);
	Appointment findByRefNo(String refNo);
	Map<String, Appointment> findAllAppt();
}
