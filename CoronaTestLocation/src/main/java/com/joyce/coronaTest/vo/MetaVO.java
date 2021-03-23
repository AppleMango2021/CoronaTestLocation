package com.joyce.coronaTest.vo;

import lombok.Data;

@Data
public class MetaVO {
	
	private int totalCount; //총 검색 건수
	private int page;		//현재 페이지 번호
	private int count;		//페이지 내 결과 개수
	
}
