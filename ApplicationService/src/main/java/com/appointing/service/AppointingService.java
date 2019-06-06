package com.appointing.service;

import com.appointing.dto.ListAvailableappointmentResponse;
import com.appointing.reserve.dto.ReserveAppointmentResponse;
import com.appointing.get.dto.Appointment;
import com.appointing.get.dto.GetAppointmentDetailsResponse;
import com.appointing.list.dto.ListAvailableAppointmentResponse;

public interface AppointingService {
	
	public ReserveAppointmentResponse reserveAppointing(String AppointmentDate, String AppointmentTimeslot );
	public ListAvailableAppointmentResponse listAppointing(String AppointmentDate);
	public GetAppointmentDetailsResponse getAppointing(String refnum);

}
