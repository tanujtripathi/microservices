package com.appointing.controller;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/validation")
public class ValidationController {

	@GetMapping("/listAppointment")
	public ResponseEntity validateListAppointing(@RequestParam("startDate") String startDate) {
		ResponseEntity responseEntity = new ResponseEntity();
		Boolean isValidDate = validateDate(startDate);
		try {
			setResponseOnDateValidation(responseEntity, isValidDate);
		} catch (DateTimeParseException e) {
			responseEntity.setResponseCode(HttpStatus.BAD_REQUEST.toString());
			responseEntity.setResponseMessage("invalid start date");
		}
		return responseEntity;

	}

	@GetMapping("/getAppointing")
	public ResponseEntity validateGetAppointing(@RequestParam("refNum ") String refNum) {
		ResponseEntity responseEntity = new ResponseEntity();
		if (null != refNum && refNum.length() == 9) {
			responseEntity.setResponseCode(HttpStatus.OK.toString());
			responseEntity.setResponseMessage("Ok");

		} else {
			responseEntity.setResponseCode(HttpStatus.BAD_REQUEST.toString());
			responseEntity.setResponseMessage("invalid refnum");

		}
		return responseEntity;

	}

	// AppointmentDate (YYYY-MM-DD) and AppointmentTimeslot (AM/PM)
	@GetMapping("/reserveAppointing")
	public ResponseEntity validateReserverAppointing(@RequestParam("appointmentDate") String appointmentDate,
			@RequestParam("appointmentTimeslot") String appointmentTimeslot) {
		ResponseEntity responseEntity = new ResponseEntity();
		try {
			boolean isValidDate = validateDate(appointmentDate);
			setResponseOnDateValidation(responseEntity, isValidDate);
			if (responseEntity.getResponseCode().equalsIgnoreCase(HttpStatus.OK.toString())) {
				validateAppointmentSlot(responseEntity, appointmentTimeslot);
			}

		} catch (DateTimeParseException e) {
			responseEntity.setResponseCode(HttpStatus.BAD_REQUEST.toString());
			responseEntity.setResponseMessage("invalid start date");
		}
		return responseEntity;

	}

	private void validateAppointmentSlot(ResponseEntity responseEntity, String appointmentTimeslot) {
		if (!(AppointmentSlot.AM.getSlot().equalsIgnoreCase(appointmentTimeslot)
				|| AppointmentSlot.AM.getSlot().equalsIgnoreCase(appointmentTimeslot))) {
			responseEntity.setResponseCode(HttpStatus.BAD_REQUEST.toString());
			responseEntity.setResponseMessage("Invalid appointmentslot");

		}
	}

	private void setResponseOnDateValidation(ResponseEntity responseEntity, Boolean isValidDate) {
		if (!isValidDate) {
			responseEntity.setResponseCode(HttpStatus.OK.toString());
			responseEntity.setResponseMessage("Ok");
		} else {
			responseEntity.setResponseCode(HttpStatus.BAD_REQUEST.toString());
			responseEntity.setResponseMessage("start date can't be previous date");
		}
	}

	private Boolean validateDate(String startDate) {
		return LocalDate.parse(startDate, java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd"))
				.isBefore(LocalDate.now());

	}

	/*
	 * private void validateInputValues(String inputXML) { try { Processor saxon
	 * = new Processor(false); DocumentBuilder documentBuilder =
	 * saxon.newDocumentBuilder(); XdmNode inboundRequestDoc =
	 * documentBuilder.build(new StreamSource(new StringReader(inputXML)));
	 * XPathCompiler xpath = saxon.newXPathCompiler(); XPathSelector selector =
	 * xpath .compile((
	 * "/*:HubServiceMessage/*:ServiceBusinessMessage/*:GetAppointmentDetailsRequest/*:CPID"
	 * )) .load(); selector.setContextItem(inboundRequestDoc); XdmValue cpid =
	 * selector.evaluate(); // System.out.println(selector.); for (XdmItem item
	 * : cpid) { System.out.println(item.toString()); } } catch (Exception e) {
	 * e.printStackTrace(); } }
	 */
}
