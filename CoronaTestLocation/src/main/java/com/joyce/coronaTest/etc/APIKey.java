package com.joyce.coronaTest.etc;

import lombok.Getter;

@Getter
public enum APIKey {
	Naver("X-NCP-APIGW-API-KEY-ID",
		  "X-NCP-APIGW-API-KEY",
		  "발급받은 인증키",
		  "발급받은 인증비밀번호");
	
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
