package com.WildCircus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReservationController {
	
	@RequestMapping("/reservation")
	public String toReservation() {
	
		return"reservation";
	}

}
