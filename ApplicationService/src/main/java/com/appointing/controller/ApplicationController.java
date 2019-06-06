package com.appointing.controller;

//import java.awt.PageAttributes.MediaType;

import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.appointing.dto.GetAppointing;
import com.appointing.dto.GetAppointmentDetails;
import com.appointing.dto.ListAvailableappointmentResponse;
import com.appointing.reserve.dto.ReserveAppointmentResponse;
import com.appointing.get.dto.Appointment;
import com.appointing.get.dto.GetAppointmentDetailsResponse;
import com.appointing.list.dto.ListAvailableAppointment;
import com.appointing.list.dto.ListAvailableAppointmentResponse;
import com.appointing.service.AppointingService;

@RestController
public class ApplicationController {

	
	//getAppointing?refNum=123
	@Autowired
	//@Consumes({MediaType.APPLICATION_JSON})
	
	AppointingService appointingService;
	@Produces({MediaType.APPLICATION_JSON})
	@GetMapping("/getAppointing")
	public GetAppointmentDetailsResponse getAppointing(@RequestParam("refNum")String refnum) {
	//public GetAppointmentResponse getAppointing(@RequestBody GetAppointmentDetails aGetAppointmentDetails) {
		System.out.println("Hello");	
	//	System.out.println("Hello"+aGetAppointmentDetails);	
		//GetAppointing aGetAppointing= new GetAppointing(); 
		//return  aGetAppointing;
		appointingService.getAppointing(refnum);
		GetAppointmentDetailsResponse getAppointmentDetailsResponse=new GetAppointmentDetailsResponse();
		return	getAppointmentDetailsResponse;
	}

	@GetMapping("/listAppointing")
	public ListAvailableAppointment listAppointing(@RequestParam("AppointmentDate")String AppointmentDate) {	
		ListAvailableAppointment listAvailableAppointment= new ListAvailableAppointment();
		appointingService.listAppointing(AppointmentDate);
		return listAvailableAppointment;
		//return appointingService.listAppointing();
	}

	@GetMapping("/reserveAppointing")
	public ReserveAppointmentResponse reserveAppointing(@RequestParam("AppointmentDate")String AppointmentDate, @RequestParam("AppointmentTimeslot")String AppointmentTimeslot) {	
		ReserveAppointmentResponse reserveAppointmentResponse=new ReserveAppointmentResponse();
		appointingService.reserveAppointing(AppointmentDate,AppointmentTimeslot );
		return reserveAppointmentResponse;
	}
	
	
	

}
