package com.ankur.demo.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ankur.demo.business.domain.RoomReservation;
import com.ankur.demo.business.service.ReservationService;

@Controller
@RequestMapping(value="/reservations")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	
		
	@RequestMapping(method= RequestMethod.GET)
	public String displayReservations(@RequestParam(value="date",required=false) String dateSupplied, Model model){
		/*Date reservationDate = new Date();
		if(null != dateSupplied){
			try{
			reservationDate = DATE_FORMAT.parse(dateSupplied);
			}catch(ParseException pEx){
				pEx.printStackTrace();
			}
		}*/
		
		//return reservationService.getReservationByDate(reservationDate);
		List<RoomReservation> roomReservationlist = reservationService.getReservationByDate(dateSupplied);
		model.addAttribute("roomReservations",roomReservationlist);
		return "reservations";
	}
}
