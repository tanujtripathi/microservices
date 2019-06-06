package com.bt.appointment.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bt.appointment.dto.GetappointmentDetails;
import com.bt.appointment.dto.GetappointmentDetailsResponse;
import com.bt.appointment.dto.ListAvailableAppointment;
import com.bt.appointment.dto.ListAvailableAppointmentResponse;
import com.bt.appointment.dto.MessageInfo;
import com.bt.appointment.dto.RequestLineMessageInfo;
import com.bt.appointment.model.Appointment;
import com.bt.appointment.repository.SQLRepository;


@RestController
@RequestMapping("api")
public class ReserveController {

	@Autowired
	SQLRepository sqlRepository;

	//Current date is the input, take 28 days record
	@RequestMapping("/list")
	public List<Appointment> getAllAppointment(@RequestParam Map<String, String> queryMap) {
		return sqlRepository.findAll();
	}
	
	@RequestMapping("/get")
	public GetappointmentDetails get(@RequestParam String app_refId) {
		Appointment appointment = sqlRepository.findOne(app_refId);
		GetappointmentDetails getappointmentDetails = new GetappointmentDetails();
		GetappointmentDetailsResponse getappointmentDetailsResponse  = new GetappointmentDetailsResponse();
		com.bt.appointment.dto.Appointment aAppointment = new com.bt.appointment.dto.Appointment();
		aAppointment.setAppointmentDate(appointment.getDate());
		aAppointment.setAppointmentTimeslot(appointment.getAm_pm());
		aAppointment.setRefNum(appointment.getApp_refId());
		getappointmentDetailsResponse.setAppointment(aAppointment);
		RequestLineMessageInfo aRequestLineMessageInfo = new RequestLineMessageInfo();
		MessageInfo aMessageInfo = new MessageInfo();
		aMessageInfo.setCompletionCode("200");
		aMessageInfo.setMessage("Success");
		aMessageInfo.setSeverity("Low");
		aRequestLineMessageInfo.setMessageInfo(aMessageInfo);
		getappointmentDetailsResponse.setRequestLineMessageInfo(aRequestLineMessageInfo);		
		getappointmentDetails.setGetappointmentDetailsResponse(getappointmentDetailsResponse);
		return getappointmentDetails;
	}
	
	
	//@RequestParam Map<Strinullng, String> queryMap
	//Reserve will call list service and choose one object and make the flag true and return APP RefiD
	@RequestMapping("/reserve")
	public ListAvailableAppointment reserve(@RequestParam Map<String, String> queryMap) {
		String about = queryMap.get("date");
		String deviceid = queryMap.get("slot");
		List<Appointment> appointmentList = getAllAppointment(queryMap);
		Appointment appointment  = appointmentList.stream().filter( o -> !o.isStatus()).findFirst().get();
		appointment.setStatus(true);
		appointment = sqlRepository.saveAndFlush(appointment);
		
		ArrayList<com.bt.appointment.dto.Appointment> aAppointmentList = new ArrayList<com.bt.appointment.dto.Appointment>();
		com.bt.appointment.dto.Appointment aAppointment = new com.bt.appointment.dto.Appointment();
		aAppointment.setAppointmentDate(appointment.getDate());
		aAppointment.setAppointmentTimeslot(appointment.getAm_pm());
		aAppointment.setRefNum(appointment.getApp_refId());
		aAppointmentList.add(aAppointment);
		ListAvailableAppointmentResponse aListAvailableAppointmentResponse = new ListAvailableAppointmentResponse();
		ListAvailableAppointment aListAvailableAppointment = new ListAvailableAppointment();
		RequestLineMessageInfo aRequestLineMessageInfo = new RequestLineMessageInfo();
		MessageInfo aMessageInfo = new MessageInfo();
		aMessageInfo.setCompletionCode("200");
		aMessageInfo.setMessage("Success");
		aMessageInfo.setSeverity("Low");
		aRequestLineMessageInfo.setMessageInfo(aMessageInfo);
		aListAvailableAppointmentResponse.setAppointment(aAppointmentList);
		aListAvailableAppointmentResponse.setRequestLineMessageInfo(aRequestLineMessageInfo);
		aListAvailableAppointment.setListAvailableAppointmentResponse(aListAvailableAppointmentResponse);
		return aListAvailableAppointment;
	}
	
}
