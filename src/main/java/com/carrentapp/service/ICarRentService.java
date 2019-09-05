package com.carrentapp.service;

import com.carrentapp.exception.CarRentException;
import com.carrentapp.request.BookingRequest;
import com.carrentapp.response.BookingResponse;

public interface ICarRentService {

	public BookingResponse calculateFare(BookingRequest bookingRequest) throws CarRentException;

}
