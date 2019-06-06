package com.appointing.controller;

public enum AppointmentSlot {
	AM("AM"), PM("PM");

	private String slot;

	AppointmentSlot(String slotValue) {
		this.slot = slotValue;
	}

	public String getSlot() {
		return slot;
	}
}
