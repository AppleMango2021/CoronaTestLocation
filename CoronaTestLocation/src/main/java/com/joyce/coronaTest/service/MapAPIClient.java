package com.joyce.coronaTest.service;



import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.joyce.coronaTest.etc.APIKey;
import com.joyce.coronaTest.vo.LocationVO;

@Component
public class MapAPIClient implements IAPIClient{
		
	private final String APIUrl = "https://naveropenapi.apigw.ntruss.com/map-static/v2/raster"
			+ "?w=300&h=300&dataversion=201.3&markers=type:d|size:mid|pos:{pos}";

	public byte[] request(List<LocationVO> locationList) {
		RestTemplate restTemplate = new RestTemplate();
		final HttpHeaders headers = new HttpHeaders();
		final HttpEntity<byte[]> entity;
		
		String pos = new String();
		int length = locationList.size();
		for (LocationVO location : locationList) {
			pos += location.getX()+" "+location.getY();
			length--;
			if(length!=0) pos+=",";
		}
		
		headers.set(APIKey.Naver.getClientID(), APIKey.Naver.getID());
		headers.set(APIKey.Naver.getClientPW(), APIKey.Naver.getPW());
		
		entity = new HttpEntity<>(headers);
		
		return restTemplate.exchange(APIUrl, 
									 HttpMethod.GET, 
									 entity, 
									 byte[].class, 
									 pos).getBody();
		
	}	
	
	
	
//	public byte[] request(GeocodeVO geocode) {
//		String pos = new String();
//		List<AddressVO> addressList = geocode.getAddresses();
//		
//		int length = addressList.size();
//		for (AddressVO address : addressList) {
//			pos += address.getX()+" "+address.getY();
//			length--;
//			if(length!=0) pos+=",";
//		}
//		
//		RestTemplate restTemplate = new RestTemplate();
//		
//		final HttpHeaders headers = new HttpHeaders();
//		headers.set("X-NCP-APIGW-API-KEY-ID", CLIENT_ID);
//		headers.set("X-NCP-APIGW-API-KEY", CLIENT_SECRET);
//		
//		
//		final HttpEntity<byte[]> entity = new HttpEntity<>(headers);
//		
//		
//		return restTemplate.exchange(naverOpenAPIUrl_getMap, HttpMethod.GET, entity, byte[].class, pos).getBody();
//		
//	}

	
	

}
