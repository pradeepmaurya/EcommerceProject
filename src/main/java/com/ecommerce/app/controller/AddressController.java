package com.ecommerce.app.controller;

import java.io.StringReader;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.h2.util.json.JSONArray;
import org.h2.util.json.JSONObject;
import org.h2.util.json.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.app.model.Address;
import com.ecommerce.app.services.AddressService;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.util.JSONPObject;

@RestController
public class AddressController {

	@Autowired
	private AddressService service;
	
	//Create Address
	@PostMapping("/address")
	private Address addAddress(@RequestBody String data) {
		
//		System.out.println("this is your print ------------**********"+data);
		Address addAddress = service.addAddress(data);
		return addAddress;
		
//		return service.addAddress(data);
	}
	
}
