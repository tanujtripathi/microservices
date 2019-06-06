package com.appointing.dto;

public class Query {

	private String RequestersID;
	private String IssueDateTime;
	RequesterParty RequesterPartyObject;
	ResponderParty ResponderPartyObject;
	QueryLine QueryLineObject;

	// Getter Methods

	public String getRequestersID() {
		return RequestersID;
	}

	public String getIssueDateTime() {
		return IssueDateTime;
	}

	public RequesterParty getRequesterParty() {
		return RequesterPartyObject;
	}

	public ResponderParty getResponderParty() {
		return ResponderPartyObject;
	}

	public QueryLine getQueryLine() {
		return QueryLineObject;
	}

	// Setter Methods

	public void setRequestersID(String RequestersID) {
		this.RequestersID = RequestersID;
	}

	public void setIssueDateTime(String IssueDateTime) {
		this.IssueDateTime = IssueDateTime;
	}

	public void setRequesterParty(RequesterParty RequesterPartyObject) {
		this.RequesterPartyObject = RequesterPartyObject;
	}

	public void setResponderParty(ResponderParty ResponderPartyObject) {
		this.ResponderPartyObject = ResponderPartyObject;
	}

	public void setQueryLine(QueryLine QueryLineObject) {
		this.QueryLineObject = QueryLineObject;
	}

}
