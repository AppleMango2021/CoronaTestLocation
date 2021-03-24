# CoronaTestLocation

## 개요
GET 요청을 통해 province와 city 값을 전달하면, Naver Static MAP APi를 통해 코로나 임시 선별진료소의 위치가 마크되어 있는 지도 이미지(.jpeg)를 리턴한다. 
처음에는 Naver Geocode API를 함께 테스트하였기 때문에, Geocode와 관련된 코드들도 남아있다. 

## 개발 배경
Java + Spring Boot의 조합으로 웹 애플리케이션 개발을 연습해보고자 시작했다. 목표는 딱 두 가지였다. 
1. Spring을 이용한 개발방법과 Spring 작동원리에 대한 기억 되살리기 
2. API 호출 구현해보기 


## 개발 환경
+ IDE : STS-3.9.4.RELEASE
+ Spring Boot : 2.1.3.RELEASE
+ Gradle : 5.2.1
+ JDK : xxx 이지만 예전 자바 문법만 사용했다. 
+ MySQL
+ MyBatis

## 얻어갈 만한 부분
Naver Static Map API를 호출해서 사용하는 방법! 
개발을 많이 해본 사람들은 잘 알만한 내용이겠지만, 나 같은 경우에는 이미지를 리턴 받으려면 리턴 타입을 뭘로 해야할 지 모르겠어서 한참을 헤맸다. 
결론은 `byte[]` 타입으로 리턴받고, `@GetMapping`에서 `produces` 속성을 `MediaType.IMAGE_JPEG_VALUE`로 설정하면 된다. 
```java
@GetMapping(value = "/map", produces = MediaType.IMAGE_JPEG_VALUE)
public @ResponseBody byte[] getStaticMapURL(@RequestParam("province") String province, 
                                            @RequestParam("city") String city) throws IOException{
		return locationService.getStaticMapURL(locationService.getGeocode(province, city));
}
```

## 새로 시도해본 것
1. Spring Boot를 처음 사용해보았다
2. Gradle도 처음 접해보았다 
3. API 호출도 처음 해보았다..!
4. Lombok도 처음 써봤다 


## 앞으로 개선/공부해나갈 것 (21.03.24 버전)
1. 프론트 붙이기 
2. Rest Template → JSON 데이터의 일부만 받고 싶으면 어떻게 해야될까? 예를 들어, 응답바디에서 englishAddress를 받고 싶지 않다면 AddressVO에서 englishAddress 변수를 제외시키기만 하면 될까?
3.  JSON의 필드명과 자바 객체의 변수명이 다른 경우에 이를 매핑하는 방법

----------------------------------------------------------------------------------
## 고민 
생각보다 DB 설계가 어렵다. 초반에는 내 스스로 요구사항도 명확하지 않아서 개발하기 편한대로 DB 설계도 막 바꾸었는데, 앞으로는 요구사항부터 명확히 작성해서 픽스해놔야겠다. 
그리고 Service를 어떤 단위로 만들어야 하는지, VO와 DTO는 어떻게 구분을 하는 것이 좋을지 등등도 고민이 많이 되었다. 
이번 실습에서는 사실상 제공할 수 있는 서비스가 1가지 밖에 없기 때문에 고민할 필요가 없었다. 
하지만 예를 들어, 쇼핑몰에서 주문내역을 보여주는 기능을 구현한다고 하자. 주문내역 테이블과 회원 테이블은 별도로 있을 것이고, 회원ID를 키로 해서 주문내역 데이터를 가져오게 될텐데, 그러면 이를 구현하는 메소드는 주문 Service에 넣어야 할까 회원 Service에 넣어야 할까? 
