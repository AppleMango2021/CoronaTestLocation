package com.joyce.coronaTest.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.joyce.coronaTest.vo.LocationVO;

@Mapper
public interface ILocationDAO {
	
	public List<LocationVO> selectList(String province, String city);
}
