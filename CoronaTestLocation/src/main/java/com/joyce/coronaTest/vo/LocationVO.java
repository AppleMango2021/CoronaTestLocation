package com.joyce.coronaTest.vo;

import lombok.Data;

@Data
public class LocationVO {
	private int id;
	private String province;
	private String city;
	private double x;
	private double y;
}
