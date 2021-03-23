package com.joyce.coronaTest.etc;

import lombok.Getter;

@Getter
public enum APIKey {
	Naver("X-NCP-APIGW-API-KEY-ID",
		  "X-NCP-APIGW-API-KEY",
		  "mrr1lb0z7z",
		  "DaE6h2Yxbi3CMFLtNm4glz9NOlRuC3q4JavTPyxn");
	
	private String ClientID;
	private String ClientPW;
	private String ID;
	private String PW;
	
	APIKey(String ClientID, String ClientPW, String ID, String PW){
		this.ClientID = ClientID;
		this.ClientPW = ClientPW;
		this.ID = ID;
		this.PW = PW;
	}
}
