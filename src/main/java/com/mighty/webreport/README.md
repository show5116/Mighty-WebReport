<h1>MIGHTY WebReport Project Back-End</h1>

<h2>Index</h2>

- <a href="#dependencies">Dependencies</a>
- <a href="#priorKnowledge">Prior Knowledge</a>
- <a href="#mvcPattern">MVC Pattern</a>
- <a href="#package">Package</a>
  * <a href="#패키지구조">패키지 구조</a> 
  * <a href="#네이밍규칙">네이밍 규칙</a>
- <a href="#security">Security</a>
- <a href="#guide">Guide</a>
  * <a href="#singleton">How to use Singleton</a>
  * <a href="#writeQuery">How to write a query</a>
  * <a href="#getUser">How to get User</a>
  * <a href="#domain">Entity & DTO</a>
- <a href="#etc">Etc</a>

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

<img src="/src/main/resources/readme/MVC.jpg">

- Controller : 컨트롤러는 Client와 데이터를 이어주는 다리역할입니다. 데이터를 가공하거나, 수정하는 코드를 작성하지 말고</br>
**request**, **response**의 데이터를 이어주는 코드를 작성하면 됩니다. Service로부터 데이터를 받아올때는 HashMap을 사용해 데이터를 받아오고,</br>
이를 통해 response를 다뤄주어 client에게 보내줍니다.

```java
@PostMapping("/signin")
public ResponseEntity<?> authenticateUser(@RequestBody AuthenticationDto authenticationDto){
    HashMap<String,Object> hashMap = loginService.setAuth(authenticationDto);
    HttpHeaders headers = new HttpHeaders();
    if((boolean)hashMap.get("isAuth")){
        headers.set("code", AuthCode.LOG_IN.getCode());
        headers.set("message",AuthCode.LOG_IN.getMessage());
    }else{
        headers.set("code", AuthCode.UNAUTHORIZED.getCode());
        headers.set("message",AuthCode.UNAUTHORIZED.getMessage());
    }
    return ResponseEntity.ok().headers(headers).body(hashMap);
}
```

- Service : interface를 작성하고, 그 메서드를 구현하는 impl코드를 다시 작성해줍니다.</br>
Service 코드는 쿼리로부터 받아온 데이터를 **비즈니스 로직**을 작성해주어서 데이터를 가공하거나 수정해주어서</br> HashMap을 통해 다시 Controller에게 데이터를 전달해줍니다.</br>
Transaction 어노테이션은 범위 내 메서드를 한 트랜잭션으로 Spring Boot에서 관리를 해주어서 Connection에 안전을 보장해줍니다.

```java
// 인터페이스는 메서드 선언을 해줍니다.
public interface ConditionService {
    public void getCustomers( HashMap<String,Object> hashMap , String plant);
    public void getOperations( HashMap<String,Object> hashMap , String plant);
    public void getDevices( HashMap<String,Object> hashMap , String plant);
}
```

```java
// Implements 에선 그 메서드를 구현해줍니다.
@Service
@RequiredArgsConstructor
public class ConditionServiceImpl implements ConditionService {

  private final CustomerRepository customerRepository;

  @Override
  @Transactional(readOnly = true)
  public void getCustomers(HashMap<String, Object> hashMap, String plant) {
    List<Customer> customers = customerRepository.findAllByPlant(plant);
    List<CustomerDto> customerDtoS = new ArrayList<>();
    for (Customer customer : customers) {
      customerDtoS.add(customer.toDTO());
    }
    hashMap.put("customers", customerDtoS);
  }
}
```

- Repository : dao와 같은 역할을 합니다. HikariCP로부터 connection을 받아서 DB와 연결하여 데이터(model)를 관리해줍니다. </br>자세한 작성방법은 <a href="#writeQuery">How to wirte query</a>를 참고해주세요.

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

<h2 id="security">Security</h2>

- 이 프로젝트는 JWT(Json Web Token)을 활용한 토큰 인증방식을 사용하고 있습니다.
  * 장점 : Session 방식보다 CSRF에 안전하고, CORS에도 비교적 안전합니다. 현재 많은 사이트가 토큰인증방식(OAuth활용)을 사용합니다.(카카오,네이버 등..)
  * 단점 : Session 방식보다 xss에 취약하여 해결방안을 찾아야합니다.
  * 해결방안 : 현재 단일 토큰 인증방식을 2중토큰 인증방식(Refresh Token)으로 업그레이드 하고,</br>
              HTTPS 세팅 및 쿠키를 활용하면 xss에도 안전해집니다.

- Query Injection : JPA의 JPQL이나 Repository를 통한 쿼리를 사용하면 보안공격에 안전하게 쿼리를 변경해줍니다.</br>
                    로그인이나, 개인정보에 관련한 쿼리를 JPA로 작성하였습니다.

- Spring Security : 보안 프레임워크로 Spring의 Interceptor를 활용하여 HttpRequest와 HttpResponse를 뺏어와 인증관리를 합니다.</br>
<a href="/src/main/java/com/mighty/webreport/config/SecurityConfig.java">SecurityConfig.java</a>중 일부
```java
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
            .cors()
                .and()
            .csrf()
                .disable()
            .exceptionHandling()
                .authenticationEntryPoint(unauthorizedHandler)
                .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
            .authorizeRequests()
                .antMatchers("/",
                        "/favicon.ico",
                        "/**/*.png",
                        "/**/*.gif",
                        "/**/*.svg",
                        "/**/*.jpg",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js")
                .permitAll()
                .antMatchers("/api/auth/**")
                .permitAll()
                .antMatchers("/api/condition/**","/api/search/**")
                .authenticated()
                .anyRequest()
                .permitAll();

        http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
    }
```
- 위의 코드는 프로젝트 전반의 보안을 관리해줍니다.
  1. antMatchers : URI를 적어주고, 그 URI마다 권한을 정해줍니다.</br>
                  permitAll()은 모든 사용자에게 허용, authenticated()는 로그인된 사용자에게 허용</br>
                  hasRoll()이나 hasAuthority()를 활용하면 특정 사용자에게만 URI를 허락해줍니다.
  2. csrf 방지
  3. exceptionHandler : <a href="/src/main/java/com/mighty/webreport/security/JwtAuthenticationEntryPoint.java">JwtAuthenticationEntryPoint.java</a>파일로 에러정보를 보내서 에러를 관리해줍니다.
  4. filter : request Header로부터 JWT를 받아와 <a href="/src/main/java/com/mighty/webreport/security/JwtAuthFilter.java">JwtAuthFilter.java</a>로 보내주어 인증정보를 확인합니다.

- Spring Security는 유저 객체를 만들어서 유저를 관리해줍니다.(<a href="/src/main/java/com/mighty/webreport/security/AccountContext.java">AccountContext.java</a>)

- <a href="/src/main/java/com/mighty/webreport/security/CustomUserDetailsService.java">CustomUserDetailsService.java</a>는 로그인 관련 로직을 실행하고, UserNameNotFound 등등.. 보안관련 Exception을 발생시킵니다.

- <a href="/src/main/java/com/mighty/webreport/security/JwtAuthProvider.java">JwtAuthProvider.java</a>는 jwt 토큰을 발급하고, 토큰을 해석하는 메서드를 구현했습니다.

<h2 id="guide">Guide</h2>

<h3 id="singleton">How to use Singleton</h3>

- Spring, Spring Boot는 Bean에 객체를 등록해주어서 Singleton 패턴을 사용합니다.(<a href="https://atoz-develop.tistory.com/entry/Spring-%EC%8A%A4%ED%94%84%EB%A7%81-%EB%B9%88Bean%EC%9D%98-%EA%B0%9C%EB%85%90%EA%B3%BC-%EC%83%9D%EC%84%B1-%EC%9B%90%EB%A6%AC">Bean이란?</a>)<br/>
Bean을 가져오는 방법은 크게 2가지가 존재합니다.
  1. @Autowired
      ```java
     // 객채에 Autowired를 어노테이션을 붙히면 Spring Bean으로 부터 찾아옵니다.
     @Autowired private CustomerRepository customerRepository;
      ```

  2. @RequiredArgsConstructor
      ```java
     // Class에 RequiredArgsConstructor를 사용해줍니다.
      @Service
      @RequiredArgsConstructor
      public class ConditionServiceImpl implements ConditionService {
            //객체를 private final로 선언을 해주면 Spring Bean으로부터 객체를 가져옵니다.
            private final CustomerRepository customerRepository;
     }
      ```
- @Autowired 방법같은 경우엔 의존성 주입을 필드 주입으로 하는데,</br>
사용방법은 간단하나, 객체 변이나, 순환참조 방지가 되지 않습니다. 따라서 2번 방법으로 코드를 작성해주시면 됩니다.

<h3 id="writeQuery">How to write query</h3>

- 쿼리를 작성하는 방법은 총 3가지 입니다.
  1. JDBC template 사용 (<a href="/src/main/java/com/mighty/webreport/domain/repository/jdbcrepository/JDBCExampleRepository.java">JDBCExampleRepository.java</a>)
  ```java
  @Repository
  @RequiredArgsConstructor
  public class JDBCExampleRepository {
  
      private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
  
      public List<LotStatusResponse> getLotStatus(String plant, String customers, String operations, String devices) {
          StringBuilder sql  = new StringBuilder();
          // query를 StringBuilder를 활용해 적어줍니다.
          // Parameter는 :변수명 으로 작성합니다.
          sql.append("select   get_operation_desc(a.plant,a.operation) as operation,");
          sql.append("         a.lot_number,");
          sql.append("         a.main_lot,");
          sql.append("         a.qty1,");
          sql.append("         a.qty1_unit,");
          sql.append("         a.qty2,");
          sql.append("         a.qty2_unit,");
          sql.append("         a.device as device,");
          sql.append("         a.customer as customer,");
          sql.append("         in_hold,hold_note,");
          sql.append("         in_rework, ");
          sql.append("         case when process_flag = 'Q' then '대기' ");
          sql.append("              when process_flag = 'P' then '작업' ");
          sql.append("              when process_flag = 'S' then '완료대기' ");
          sql.append("         else '?'   ");
          sql.append("          end  as process_flag ,");
          sql.append("       (select attribute_value from asfc_attribute_status where plant = a.plant and lot_number = a.lot_number and attribute_index = 1) as device_ver,");
          sql.append("       (select attribute_value from asfc_attribute_status where plant = a.plant and lot_number = a.lot_number and attribute_index = 2) as device_attribute,");
          sql.append("       (select attribute_value from asfc_attribute_status where plant = a.plant and lot_number = a.lot_number and attribute_index = 3) as ship_attribute, ");
          sql.append("         route, ");
          sql.append("         a.enter_oper_time,");
          sql.append("         b.equipment_id ");
          sql.append(" from asfc_lot_status a,");
          sql.append("      asfc_eqplot_status b ");
          sql.append("where a.plant = :plant ");
          sql.append("  and a.plant = b.plant(+)");
          sql.append("  and a.lot_number = b.lot_number(+)");
          sql.append("  and status <> '99' ");
          
          // 동적쿼리는 if문을 사용해줍니다.
          if (!operations.isEmpty()){
              sql.append("  and ( a.operation IN ( '" + operations + "' ) ) ");
          }
  
          if (!devices.isEmpty()){
              sql.append("  and ( a.device IN ( '" + devices + "' ) ) ");
          }
  
          if (!customers.isEmpty()){
              sql.append("   and a.customer in ('" + customers + "') ");
          }
  
          sql.append("order by LENGTH(a.OPERATION), 1,2,3,8,9");
          
          // :변수명 으로 등록한 parameter에 값을 매핑해줍니다.
          SqlParameterSource namedParameters = new MapSqlParameterSource("plant",plant);
  
          // RowMapper는 ResultSet 담겨오는 데이터를 객체에 바인딩해줍니다.
          RowMapper<LotStatusResponse> lotStatusMapper = (rs, rowNum) -> {
            return LotStatusResponse.builder()
                    .operation(rs.getString("operation"))
                    .lotNumber(rs.getString("lot_number"))
                    .mainLot(rs.getString("main_lot"))
                    .qtyOne(rs.getInt("qty1"))
                    .qtyUnitOne(rs.getString("qty1_unit"))
                    .qtyTwo(rs.getInt("qty2"))
                    .qtyUnitTwo(rs.getString("qty2_unit"))
                    .device(rs.getString("device"))
                    .customer(rs.getString("customer"))
                    .inHold(rs.getString("in_hold").charAt(0))
                    .holdNote(rs.getString("hold_note"))
                    .inRework(rs.getString("in_rework").charAt(0))
                    .processFlag(rs.getString("process_flag"))
                    .deviceVer(rs.getString("device_ver"))
                    .deviceAttribute(rs.getString("device_attribute"))
                    .shipAttribute(rs.getString("ship_attribute"))
                    .route(rs.getString("route"))
                    .enterOperTime(rs.getString("enter_oper_time"))
                    .equipmentId(rs.getString("equipment_id"))
                    .build();
          };
  
          // 쿼리 결과값을 반환해줍니다.
          return namedParameterJdbcTemplate.query(sql.toString(),namedParameters,lotStatusMapper);
      }
  }
  ```
  
  2. JPA Repository 사용 (<a href="/src/main/java/com/mighty/webreport/domain/repository/jparepository/CalendarRepository.java">CalendarRepository.java</a>)
  ```java
  @Repository
  public interface CalendarRepository extends JpaRepository<Calendar, CalendarId> {
    // 쿼리 조건을 작성하면 JPA가 자동으로 쿼리를 생성해줍니다.
    List<Calendar> findAllByNaturalDateBetweenAndPlant(String startDate,String endDate, String plant);
  }
  ```
  
  3. QueryDSL 사용 : Entity를 생성하고, 프로젝트 빌드를 하면 QClass가 생성됩니다.(<a href="/src/main/java/com/mighty/webreport/domain/repository/querydsl/impl/DeviceRepositoryImpl.java">DeviceRepositoryImpl.java</a>)</br>
  QClass를 불러서 쿼리를 객체지향적으로 작성합니다.</br>
  장점은 parameter 기법으로 쿼리를 재생성해주고, 객체를 조회해줍니다.</br>
  단점은 inline View(from절 서브쿼리)를 작성할 수 없습니다.</br>
  따라서 이부분은 Native Query나, Service에서 비즈니스 로직으로 처리해야합니다.
  ```java
  @Repository
  @RequiredArgsConstructor
  public class DeviceRepositoryImpl implements DeviceRepositoryCustom {
  
      private final JPAQueryFactory jpaQueryFactory;
  
      @Override
      public List<DeviceResponse> getDevice(String plant) {
          return jpaQueryFactory
                  .select(Projections.fields(DeviceResponse.class,
                          deviceSpec.device.deviceId,
                          deviceSpec.device.description,
                          deviceCustomer.customer))
                  .from(deviceSpec)
                  .innerJoin(deviceSpec.device , device)
                  .innerJoin(deviceCustomer)
                  .on(deviceSpec.deviceId.eq(deviceCustomer.device)
                  .and(deviceSpec.plant.eq(deviceCustomer.plant)))
                  .where(deviceSpec.device.plant.eq(plant)
                  .and(deviceSpec.disContinue.eq('N')))
                  .orderBy(deviceSpec.deviceId.asc())
                  .fetch();
      }
  }
  ```

<h3 id="getUser">How to get User</h3>

- Spring Security에서 filter로부터 JWT토큰을 받아 현재 로그인되어있는 유저의 정보를 받아와줍니다.</br>
  <a href="/src/main/java/com/mighty/webreport/service/impl/JDBCExampleServiceImpl.java">JDBCExampleServiceImpl</a>중 일부
```java
@Override
@Transactional(readOnly = true)
public void getLotStatus(HashMap<String,Object> hashMap, CDODto dto){
    // Security로부터 Context를 가져와서 로그인된 정보를 가져옵니다.(Authentication 객체)
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    // 로그인된 정보에서 유저정보를 가져와줍니다.
    AccountContext accountContext = (AccountContext) authentication.getPrincipal();

    List<LotStatusResponse> lotStatus = jdbcExampleRepository.getLotStatus(accountContext.getPlant(),
            dto.getCustomersString(),
            dto.getOperationsString(),
            dto.getDevicesString());

    hashMap.put("lotStatus",lotStatus);
}
```

<h3 id="domain">Entity & DTO</h3>

- 변수명 규칙 : 변수명은 snake_case 가 아닌 camelCase로 변경해주는게 좋습니다.</br>
  그 이유는 javaScript에서 result.data.MESSAGE_ID 이런식의 사용에서 언더바('_')에 에러가 생기기 때문에 코드를 돌려서 작성하게 됩니다.
```java
    // DB의 컬럼 이름
    @Column(name = "MESSAGE_ID")
    // 실제로 사용할 변수 이름
    private String messageId;
```

- Entity는 JPA를 사용하기 위해 필요한 객체입니다. 테이블의 모든 정보를 받아오는게 좋습니다.(<a href="/src/main/java/com/mighty/webreport/domain/entity/automate/EquipmentLotStatus.java">예시</a>)</br>
  기본키, 외래키, 복합키를 선언해주고 Entity 사이의 관계를 매핑해주어야 합니다.

- DTO는 Response에 담아서 Client에 보내줄 데이터 형식과, Request로부터 받아올 데이터 형식입니다.(...Dto는 받아올, ...Resposnse는 보내줄 객체)</br>
  트래픽 낭비를 방지하기 위해 필요한 데이터만을 사용해주는게 좋습니다.(<a href="/src/main/java/com/mighty/webreport/domain/dto/OperationResponse.java">예시</a>)

<h2 id="etc">Etc</h2>

- 보안관련이나, 프로젝트 세팅, 궁금한점은 연락 부탁드립니다.
