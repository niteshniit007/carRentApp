package com.carrentapp.constant;

public enum VechicleEnum {
	
	CAR(5), SUV(7), BUS(32), VAN(20);

    private final int capacity;

	VechicleEnum(int capacity){
		this.capacity = capacity;
	}
	
	 public int getCapacity() {
	        return this.capacity;
	 }
	    
}
