package com.joyce.coronaTest.controller;

import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joyce.coronaTest.service.LocationService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Controller
public class LocationController {

	private final LocationService locationService;
	
	@GetMapping(value = "/map", 
					produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[] getStaticMapURL(@RequestParam("province") String province, 
												@RequestParam("city") String city) throws IOException{
		return locationService.getStaticMapURL(locationService.getGeocode(province, city));
	}
}
