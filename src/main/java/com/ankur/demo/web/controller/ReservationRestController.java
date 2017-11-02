package com.ankur.demo.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ankur.demo.business.domain.RoomReservation;
import com.ankur.demo.business.service.ReservationService;

@RestController
@RequestMapping(value="/api")
public class ReservationRestController {
	
	@Autowired
	ReservationService reservationService;

	@RequestMapping(method= RequestMethod.GET,value="/reservations/{date}")
	public List<RoomReservation> displayReservations(@PathVariable(value="date") String dateString){
		return reservationService.getReservationByDate(dateString);
	}
}

