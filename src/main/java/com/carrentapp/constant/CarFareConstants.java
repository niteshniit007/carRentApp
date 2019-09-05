package com.carrentapp.constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface CarFareConstants {

	int PERTROL_VECHICLE_STANDARD_RATE = 15;
	int DIESEL_VECHICLE_STANDARD_RATE = PERTROL_VECHICLE_STANDARD_RATE - 1;
	int AC_CHARGE = 2;
	int BUS_RATE = (DIESEL_VECHICLE_STANDARD_RATE - (DIESEL_VECHICLE_STANDARD_RATE*2/100));
	List<String> CAR_LIST =  new ArrayList<>(Arrays.asList("SWIFT","ALTO", "I10", "I20"));
	String P_FULE= "PETROL";
	String D_FULE = "DIESEL";
	String BUS = "BUS";
	String VAN = "VAN";
	String SUV = "SUV";
}

