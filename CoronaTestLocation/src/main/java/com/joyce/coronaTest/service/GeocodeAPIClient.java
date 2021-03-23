package com.joyce.coronaTest.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.joyce.coronaTest.etc.APIKey;
import com.joyce.coronaTest.vo.GeocodeVO;

@Component
public class GeocodeAPIClient implements IAPIClient {
	
	private final String APIUrl = "https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode?query={keyword}";
		
	public GeocodeVO request(String keyword) {
		RestTemplate restTemplate = new RestTemplate();
		final HttpHeaders headers = new HttpHeaders();
		final HttpEntity<GeocodeVO> entity;
		
		headers.set(APIKey.Naver.getClientID(), APIKey.Naver.getID());
		headers.set(APIKey.Naver.getClientPW(), APIKey.Naver.getPW());
		
		entity = new HttpEntity<>(headers);
		return restTemplate.exchange(	APIUrl, 
										HttpMethod.GET, 
										entity,
										GeocodeVO.class, 
										keyword).getBody();
	}	
}
