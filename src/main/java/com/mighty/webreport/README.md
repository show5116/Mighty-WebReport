<h1>MIGHTY WebReport Project Back-End</h1>

<h2>Index</h2>

- <a href="#dependencies">Dependencies</a>
- <a href="#priorKnowledge">Prior Knowledge</a>
- <a href="#mvcPattern">MVC Pattern</a>
- <a href="#package">Package</a>
- <a href="#writeQuery">How to write a query</a>
- <a href="#urlMapping">URI Mapping</a>
- <a href="#security">Security</a>
- <a href="#guide">Guide</a>


<h2 id="dependencies">Dependencies</h2>

|       **기술명**       |  **버전**   | **설명**                                                                               |
|:-------------------:|:---------:|:-------------------------------------------------------------------------------------|
|   **Spring Boot**   |   2.6.7   | IOC와 DI를 활용한 객체관리 아키텍처인 Spring을 보다 용이하게 사용                                           |
|   **Spring Web**    |   2.6.7   | Spring 내장인 WAS Tomcat 서버를 구축하고, RESTful 서비스 개발하는데 사용                                 |
| **Spring Security** |   2.6.7   | CORS, CSRF를 방지하고, Interceptor를 이용해 URL 별로 권한을 설정                                     |
|      **jjwt**       |  0.11.5   | JSON Web Token 생성 및 해독                                                               |
|       **JPA**       |   2.6.7   | ORM중 하나, DB 테이블을 객체 단위로 매핑하여서 객체지향적으로 데이터 관리,</br> Parameter 방법으로 Query Injection 안전 |
|    **QueryDSL**     |   5.0.0   | JPA JPQL을 객체지향적으로 관리 가능하게 해주는 query 라이브러리                                            |

<h2 id="priorKnowledge">Prior Knowledge</h2>

- java(jdk8)
- RESTful API
    * URI 규칙(<a href="https://sabarada.tistory.com/28?category=800100">참고자료</a>)
    * http method(<a href="https://sabarada.tistory.com/29">참고자료</a>)
- Spring Boot
    * Bean(<a href="https://atoz-develop.tistory.com/entry/Spring-%EC%8A%A4%ED%94%84%EB%A7%81-%EB%B9%88Bean%EC%9D%98-%EA%B0%9C%EB%85%90%EA%B3%BC-%EC%83%9D%EC%84%B1-%EC%9B%90%EB%A6%AC">참고자료</a>)
    * Response Entity(<a href="https://devlog-wjdrbs96.tistory.com/182">참고자료</a>)
- JPA Data(선택사항)
    * dto와 Entity의 차이(<a href="https://wildeveloperetrain.tistory.com/101">참고자료</a>)

<h2 id="mvcPattern">MVC Pattern</h2>

<img src="../../../../../../src/main/resources/readme/MVC.jpg">

<h2 id="package">Package</h2>

<h3 id="패키지구조">패키지 구조</h3>

```bash
├── config/
├── controller/
├── domain/
│   ├── dto/
│   ├── entity/
│   └── repository
│       ├── jdbcrepository
│       ├── jparepository
│       └── querydsl
├── security/
└── service/
```

|    패키지명    | 설명                                                                   |
|:----------:|:---------------------------------------------------------------------|
|   config   | Web을 포함해서 Back-End의 configuration 관리                                 |
| controller | client의 요청을 http metohds로 받아서 service에 이어주고,</br>결과를 response에 담아 전송 |
|   domain   | data를 관리, 위의 dto와 entity의 차이점 참고, repository는 dao와 같은역할              |
|  security  | 프로젝트의 보안 및 에러 관리                                                     |
|  service   | 비즈니스 로직, 한 메소드가 한 transaction이 되어서 connection을 관리                    |

<h3 id="네이밍규칙">네이밍 규칙</h3>

- package는 소문자, class는 PascalCase, method, field는 camelCase를 기본으로 합니다.

- entity는 테이블 명을 바탕으로 네이밍, repository는 entity이름 뒤에 Repository를 붙혀줍니다.

- controller,service는 기능에 따라 나누어주고 이름의 뒤에 각각 Controller, Service를 붙혀줍니다.

<h2 id="writeQuery">How to write a query</h2>

<h2 id="urlMapping">URI Mapping</h2>

<h2 id="security">Security</h2>

<h2 id="guide">Guide</h2>
