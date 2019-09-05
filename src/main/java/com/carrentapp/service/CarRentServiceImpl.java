package com.carrentapp.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.carrentapp.constant.CarFareConstants;
import com.carrentapp.constant.VechicleEnum;
import com.carrentapp.exception.CarRentException;
import com.carrentapp.request.BookingRequest;
import com.carrentapp.response.BookingResponse;

@Service
public class CarRentServiceImpl implements ICarRentService{

	@Override
	public BookingResponse calculateFare(BookingRequest bookingRequest) throws CarRentException {
		BookingResponse bookingResponse = new BookingResponse();
		int totalDistance = bookingRequest.getTotalDistance();
		String places = bookingRequest.getFrom() + "-" + bookingRequest.getTo();
		if(bookingRequest.getWithReturn()) {
			totalDistance = totalDistance*2;
			places = places + "-" + bookingRequest.getFrom();
		}
		int fareRate = calculateFareRate(bookingRequest.getVehicleType(), bookingRequest.getFuelType(), bookingRequest.getWithAC(),
				bookingRequest.getNumberOfPassanger());
		if(fareRate > 0) {
			bookingResponse.setFare(fareRate * totalDistance);
			bookingResponse.setPlaces(places);
			bookingResponse.setTotalDistance(totalDistance);
		}else {
			throw new CarRentException("Something went wrong, please contact admin.");
		}
		return bookingResponse;
	}
	
	private int calculateFareRate(String vehicleType, String fuelType, Boolean withAC, Integer capacity) {
		int fareRate = 0;
		if(!StringUtils.isEmpty(vehicleType)) {
			if(CarFareConstants.CAR_LIST.contains(vehicleType.trim())) {
				if(CarFareConstants.P_FULE.equalsIgnoreCase(fuelType.trim())){
					fareRate = CarFareConstants.PERTROL_VECHICLE_STANDARD_RATE;
				}else {
					fareRate = CarFareConstants.DIESEL_VECHICLE_STANDARD_RATE;
				}
				if(withAC) {
					fareRate = fareRate + 2;
				}
				int extraPassanger = capacity - VechicleEnum.CAR.getCapacity();
				if(extraPassanger > 0){
					fareRate = fareRate + extraPassanger;
				}
			}else if(CarFareConstants.BUS.equalsIgnoreCase(vehicleType.trim())){
				fareRate = CarFareConstants.BUS_RATE;
				int extraPassanger = capacity - VechicleEnum.BUS.getCapacity();
				if(extraPassanger > 0){
					fareRate = fareRate + extraPassanger;
				}
			}else if(CarFareConstants.SUV.equalsIgnoreCase(vehicleType.trim())){
				fareRate = CarFareConstants.DIESEL_VECHICLE_STANDARD_RATE;
				int extraPassanger = capacity - VechicleEnum.SUV.getCapacity();
				if(extraPassanger > 0){
					fareRate = fareRate + extraPassanger;
				}
			} else if(CarFareConstants.VAN.equalsIgnoreCase(vehicleType.trim())){
				fareRate = CarFareConstants.DIESEL_VECHICLE_STANDARD_RATE;
				int extraPassanger = capacity - VechicleEnum.VAN.getCapacity();
				if(extraPassanger > 0){
					fareRate = fareRate + extraPassanger;
				}
			}
		}
		return fareRate;
	}
	

}
