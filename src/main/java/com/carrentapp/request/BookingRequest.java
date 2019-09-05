package com.carrentapp.request;

public class BookingRequest {

	private String vehicleType;
	private String fuelType;
	private String to;
	private String from;
	private Boolean withReturn;
	private Integer totalDistance;
	private Boolean withAC;
	private Integer numberOfPassanger;
	
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	
	public String getTo() {
		return to;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public Integer getTotalDistance() {
		return totalDistance;
	}
	public void setTotalDistance(Integer totalDistance) {
		this.totalDistance = totalDistance;
	}
	public Boolean getWithAC() {
		return withAC;
	}
	public void setWithAC(Boolean withAC) {
		this.withAC = withAC;
	}
	public Integer getNumberOfPassanger() {
		return numberOfPassanger;
	}
	public void setNumberOfPassanger(Integer numberOfPassanger) {
		this.numberOfPassanger = numberOfPassanger;
	}
	
	public Boolean getWithReturn() {
		return withReturn;
	}
	public void setWithReturn(Boolean withReturn) {
		this.withReturn = withReturn;
	}
	@Override
	public String toString() {
		return "BookingRequest [vehicleType=" + vehicleType + ", fuelType=" + fuelType + ", to=" + to + ", from=" + from
				+ ", withReturn=" + withReturn + ", totalDistance=" + totalDistance + ", withAC=" + withAC
				+ ", numberOfPassanger=" + numberOfPassanger + "]";
	}
	
	

	
}
