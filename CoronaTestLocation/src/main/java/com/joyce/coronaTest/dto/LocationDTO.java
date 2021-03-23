package com.joyce.coronaTest.dto;

import lombok.Data;

@Data
public class LocationDTO {
	private String status;
	private int id;
	private String province;
	private String city;
	private String gu;
	private String address1;
	private boolean isOpen;
	private String comment;
	private double x;
	private double y;
}
