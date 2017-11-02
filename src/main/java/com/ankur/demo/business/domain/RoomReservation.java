package com.ankur.demo.business.domain;

import java.util.Date;

public class RoomReservation {

	private long roomId;
	
	private String roomName;
	
	private String roomNumber;
	
	private long guestId;
	
	private long reservationId;
	
	private String guest_fname;
	
	private String guest_lname;
	
	private String guestEmail;
	
	private String guestAddress;
	
	private String guestState;
	
	private String guestCountry;
	
	private String guestPhone;
	
	private Date date;

	public long getRoomId() {
		return roomId;
	}

	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public long getGuestId() {
		return guestId;
	}

	public void setGuestId(long guestId) {
		this.guestId = guestId;
	}

	public long getReservationId() {
		return reservationId;
	}

	public void setReservationId(long reservationId) {
		this.reservationId = reservationId;
	}

	public String getGuest_fname() {
		return guest_fname;
	}

	public void setGuest_fname(String guest_fname) {
		this.guest_fname = guest_fname;
	}

	public String getGuest_lname() {
		return guest_lname;
	}

	public void setGuest_lname(String guest_lname) {
		this.guest_lname = guest_lname;
	}

	public String getGuestEmail() {
		return guestEmail;
	}

	public void setGuestEmail(String guestEmail) {
		this.guestEmail = guestEmail;
	}

	public String getGuestAddress() {
		return guestAddress;
	}

	public void setGuestAddress(String guestAddress) {
		this.guestAddress = guestAddress;
	}

	public String getGuestState() {
		return guestState;
	}

	public void setGuestState(String guestState) {
		this.guestState = guestState;
	}

	public String getGuestCountry() {
		return guestCountry;
	}

	public void setGuestCountry(String guestCountry) {
		this.guestCountry = guestCountry;
	}

	public String getGuestPhone() {
		return guestPhone;
	}

	public void setGuestPhone(String guestPhone) {
		this.guestPhone = guestPhone;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
