package com.carrentapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.carrentapp.exception.CarRentException;
import com.carrentapp.request.BookingRequest;
import com.carrentapp.response.BookingResponse;
import com.carrentapp.service.ICarRentService;

@RestController
public class CarRentController {
	
	@Autowired 
	ICarRentService carRentService;
	
	@PostMapping(path="/calculateFare")
	public BookingResponse calculateFare(@RequestBody BookingRequest bookingRequest) throws CarRentException
	{
		BookingResponse bookingResponse= carRentService.calculateFare(bookingRequest);
		return bookingResponse;
	}

	@ExceptionHandler(CarRentException.class)
	public ModelAndView handleCarRentException(HttpServletRequest request, Exception ex){
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("exception", ex);
	    modelAndView.addObject("url", request.getRequestURL());
	    modelAndView.setViewName("error");
	    return modelAndView;
	}
}
