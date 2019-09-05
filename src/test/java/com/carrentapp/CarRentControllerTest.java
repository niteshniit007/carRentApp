package com.carrentapp;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.carrentapp.request.BookingRequest;
import com.carrentapp.response.BookingResponse;
import com.carrentapp.service.ICarRentService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CarRentControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ICarRentService carRentService;
	
	@Test
	public void calculateFare() throws Exception {
		String requestJsonString = "{\n" + 
				"    \"vehicleType\": \"SWIFT\",\n" + 
				"    \"fuelType\": \"DIESEL\",\n" + 
				"    \"to\": \"Mumbai\",\n" + 
				"    \"from\": \"Pune\",\n" + 
				"    \"withReturn\":0,\n" + 
				"    \"totalDistance\": 200,\n" + 
				"    \"withAC\": 0,\n" + 
				"    \"numberOfPassanger\": 5\n" + 
				"}";
		String responseJsonString = "{\n" + 
				"    \"totalDistance\": 200,\n" + 
				"    \"places\": \"Pune-Mumbai\",\n" + 
				"    \"fare\": 2800\n" + 
				"}"; 
		BookingRequest bookingRequest = new ObjectMapper().readValue(requestJsonString, BookingRequest.class);
		BookingResponse bookingResponse = new ObjectMapper().readValue(responseJsonString, BookingResponse.class);
		Mockito.when(carRentService.calculateFare(bookingRequest)).thenReturn(bookingResponse);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/calculateFare")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(requestJsonString);

		mockMvc.perform(requestBuilder).andExpect(status().isOk());
	}
		
}
