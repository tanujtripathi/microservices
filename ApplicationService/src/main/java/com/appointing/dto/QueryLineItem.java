package com.appointing.dto;

public class QueryLineItem {

	private String RequestersID;
	Features FeaturesObject;

	// Getter Methods

	public String getRequestersID() {
		return RequestersID;
	}

	public Features getFeatures() {
		return FeaturesObject;
	}

	// Setter Methods

	public void setRequestersID(String RequestersID) {
		this.RequestersID = RequestersID;
	}

	public void setFeatures(Features FeaturesObject) {
		this.FeaturesObject = FeaturesObject;
	}

}
