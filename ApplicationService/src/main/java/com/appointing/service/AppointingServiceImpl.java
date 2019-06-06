package com.appointing.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.appointing.dto.AppoinitngValidationResponse;
import com.appointing.get.dto.GetAppointmentDetailsResponse;
import com.appointing.list.dto.ListAvailableAppointmentResponse;
//import com.appointing.dto.ListAvailableappointmentResponse;
import com.appointing.reserve.dto.ReserveAppointmentResponse;

@Component
public class AppointingServiceImpl implements AppointingService {

	RestTemplate restTemplate = new RestTemplate();

	@Override
	public ReserveAppointmentResponse reserveAppointing(String AppointmentDate, String AppointmentTimeslot) {

		ReserveAppointmentResponse reserveAppointmentResponse = new ReserveAppointmentResponse();
		AppoinitngValidationResponse appoinitngValidationResponse = new AppoinitngValidationResponse();
		appoinitngValidationResponse = validationReserveCall(AppointmentDate, AppointmentTimeslot);

		if (StringUtils.equalsIgnoreCase(appoinitngValidationResponse.getResponseMessage(), "200")) {

			String isAvailable = getAvailableEngineerInfo("1234");

			if (StringUtils.equalsIgnoreCase(isAvailable, "yes")) {
				// rabbit mq
				// return reserveAppointmentResponse;

			} else {
				// Failed Reserve call
				// return reserveAppointmentResponse;

			}
		}
		return reserveAppointmentResponse;
	}
	
	@Override
	public GetAppointmentDetailsResponse getAppointing(String refnum) {

		return null;
	}

	@Override
	public ListAvailableAppointmentResponse listAppointing(String AppointmentDate) {
		ListAvailableAppointmentResponse listAvailableAppointmentResponse = new ListAvailableAppointmentResponse();
		validationListCall(AppointmentDate);
		return listAvailableAppointmentResponse;
	}


	public AppoinitngValidationResponse validationGetCall(String refNum) {
		String url = "http://localhost:8080/validation/listAppointment";
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url).queryParam("refNum", refNum);
		ResponseEntity<AppoinitngValidationResponse> responseEntity = restTemplate.exchange(uriBuilder.toUriString(),
				HttpMethod.GET, null, AppoinitngValidationResponse.class);

		return responseEntity.getBody();

	}

	public AppoinitngValidationResponse validationListCall(String startDate) {

		String url = "http://localhost:8080/validation/listAppointment";
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url).queryParam("startDate", startDate);
		ResponseEntity<AppoinitngValidationResponse> responseEntity = restTemplate.exchange(uriBuilder.toUriString(),
				HttpMethod.GET, null, AppoinitngValidationResponse.class);

		return responseEntity.getBody();

	}

	public AppoinitngValidationResponse validationReserveCall(String AppointmentDate, String AppointmentTimeslot) {

		String url = "http://localhost:8080/validation/listAppointment";
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url)
				.queryParam("AppointmentDate", AppointmentDate).queryParam("AppointmentTimeslot", AppointmentTimeslot);
		ResponseEntity<AppoinitngValidationResponse> responseEntity = restTemplate.exchange(uriBuilder.toUriString(),
				HttpMethod.GET, null, AppoinitngValidationResponse.class);

		return responseEntity.getBody();

	}

	public String getAvailableEngineerInfo(String referenceId) {

		String engineersUrl = "http://localhost:8080/getAvailableEngineers/" + referenceId;

		ResponseEntity<String> result = restTemplate.getForEntity(engineersUrl, String.class);

		return result.getBody();

	}

	public String post(String referenceId) {

		String engineersUrl = "http://localhost:8080/getAvailableEngineers/" + referenceId;

		ResponseEntity<String> result = restTemplate.getForEntity(engineersUrl, String.class);

		return result.getBody();

	}
	public AppoinitngValidationResponse ReserveCall(String AppointmentDate, String AppointmentTimeslot) {

		String url = "http://localhost:8305/api/reserve";
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url)
				.queryParam("date", AppointmentDate).queryParam("slot", AppointmentTimeslot);
		ResponseEntity<AppoinitngValidationResponse> responseEntity = restTemplate.exchange(uriBuilder.toUriString(),
				HttpMethod.GET, null, AppoinitngValidationResponse.class);
		return responseEntity.getBody();

	}
	
	public AppoinitngValidationResponse ListCall(String startDate) {

		String url = "http://localhost:8080/validation/listAppointment";
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url).queryParam("startDate", startDate);
		ResponseEntity<AppoinitngValidationResponse> responseEntity = restTemplate.exchange(uriBuilder.toUriString(),
				HttpMethod.GET, null, AppoinitngValidationResponse.class);

		return responseEntity.getBody();

	}
	
	public AppoinitngValidationResponse GetCall(String refNum) {
		String url = "http://localhost:8305/api/get";
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url).queryParam("app_refId", refNum);
		ResponseEntity<AppoinitngValidationResponse> responseEntity = restTemplate.exchange(uriBuilder.toUriString(),
				HttpMethod.GET, null, AppoinitngValidationResponse.class);

		return responseEntity.getBody();

	}

	

}
