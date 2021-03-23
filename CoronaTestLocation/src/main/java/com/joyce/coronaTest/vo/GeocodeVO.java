package com.joyce.coronaTest.vo;
import java.util.List;

import lombok.Data;

@Data
public class GeocodeVO {
	private MetaVO meta;
	private List<AddressVO> addresses;
}
