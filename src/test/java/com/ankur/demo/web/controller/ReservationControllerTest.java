package com.ankur.demo.web.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ankur.demo.business.domain.RoomReservation;
import com.ankur.demo.business.service.ReservationService;

import static org.mockito.BDDMockito.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(ReservationController.class)
public class ReservationControllerTest {
	
	@MockBean
	private ReservationService mockReservationService;
	
	@Autowired
	private MockMvc mockMvc;
	
	private static final DateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd");
	
	@Test
	public void testReservationController() throws Exception
	{
		String dateString =  "2017-01-01";
		List<RoomReservation> mockReservationList = new ArrayList<>();
		mockReservationList.add(createMockRoomReservation(dateString));
		given(mockReservationService.getReservationByDate(dateString)).willReturn(mockReservationList);
		
		mockMvc.perform(get("/reservations.html?date=2017-01-01")).andExpect(status().isOk()).andExpect(content().string(containsString("Test, JUnit")));
		
	}

	private RoomReservation createMockRoomReservation(String dateString) throws ParseException {
		RoomReservation roomReservation = new RoomReservation();
		roomReservation.setGuest_fname("JUnit");
		roomReservation.setGuest_lname("Test");
		roomReservation.setRoomId(100);
		roomReservation.setRoomName("MyRoom");
		roomReservation.setDate(DATE_FORMATTER.parse(dateString));
		return roomReservation;
	}

}
