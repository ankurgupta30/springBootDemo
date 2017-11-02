package com.ankur.demo.business.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ankur.demo.business.domain.RoomReservation;
import com.ankur.demo.data.entity.Guest;
import com.ankur.demo.data.entity.Reservation;
import com.ankur.demo.data.entity.Room;
import com.ankur.demo.data.repository.GuestRepository;
import com.ankur.demo.data.repository.ReservationRepository;
import com.ankur.demo.data.repository.RoomRepository;

@Service
public class ReservationService {
	
	private GuestRepository guestRepository;
	private RoomRepository roomRepository;
	private ReservationRepository reservationRepository;
	
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	public ReservationService(GuestRepository guestRepository, RoomRepository roomRepository,
			ReservationRepository reservationRepository) {
		super();
		this.guestRepository = guestRepository;
		this.roomRepository = roomRepository;
		this.reservationRepository = reservationRepository;
	}


	private java.sql.Date convertToDate(String dateSupplied){
		Date reservationDate = new Date();
		if(null != dateSupplied){
			try{
			reservationDate = DATE_FORMAT.parse(dateSupplied);
			}catch(ParseException pEx){
				pEx.printStackTrace();
			}
		}
		return new java.sql.Date(reservationDate.getTime());
	}
	
	public List<RoomReservation> getReservationByDate(String dateString){
		Map<Long,RoomReservation> roomReservationMap = new HashMap<Long,RoomReservation>();
		Iterable<Room> rooms = roomRepository.findAll();
		rooms.forEach(room -> {
			RoomReservation roomReservation =  new RoomReservation();
			roomReservation.setRoomId(room.getId());
			roomReservation.setRoomName(room.getName());
			roomReservation.setRoomNumber(room.getNumber());
			roomReservationMap.put(room.getId(), roomReservation);
		});
		
		List<Reservation> allReservations = reservationRepository.findByDate(convertToDate(dateString));
		allReservations.forEach(reservation -> {
			
			Guest guest = guestRepository.findOne(reservation.getGuestId());
			RoomReservation roomReservation = roomReservationMap.get(reservation.getRoomId());
			roomReservation.setGuestId(guest.getId());
			roomReservation.setGuest_fname(guest.getFirstName());
			roomReservation.setGuest_lname(guest.getLastName());
			roomReservation.setDate(reservation.getDate());
			roomReservation.setGuestAddress(guest.getAddress());
			roomReservation.setGuestState(guest.getState());
			roomReservation.setGuestCountry(guest.getCountry());
			roomReservation.setGuestPhone(guest.getPhone());
			
		});
		
		List<RoomReservation> reservations = new ArrayList<>();
		for(Long roomId:roomReservationMap.keySet()){
			reservations.add(roomReservationMap.get(roomId));
			
		}
		return reservations;
	}
}
