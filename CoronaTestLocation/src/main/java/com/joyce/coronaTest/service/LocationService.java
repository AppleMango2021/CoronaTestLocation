package com.joyce.coronaTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joyce.coronaTest.dao.ILocationDAO;
import com.joyce.coronaTest.vo.GeocodeVO;
import com.joyce.coronaTest.vo.LocationVO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class LocationService {
	
	private final GeocodeAPIClient geocodeApiClient;
	private final MapAPIClient mapApiClient;
	
	@Autowired
	private ILocationDAO dao;
	
/**
 * 
 * @param province
 * @param city
 * @return List<LocationVO>
 * 
 * 입력 받은 province와 city 값으로 위/경도 select 
 */
	public List<LocationVO> getGeocode(String province, String city) {
		return dao.selectList(province, city);
	}

/**
 * 
 * @param locationList
 * @return byte[] 
 * 
 * 위/경도 데이터를 바탕으로 static map(.jpeg) 리턴
 */
	public byte[] getStaticMapURL(List<LocationVO> locationList) {
		
		return mapApiClient.request(locationList);
	}
	
}
