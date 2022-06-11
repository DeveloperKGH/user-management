# 회원관리 

회원관리 관련 기능 단순 CRUD
- 회원가입 API
- 비밀번호 변경 API
- 회원삭제 API

### 사용기술
Spring Boot 2.7.0, Gradle, JAVA 8, JPA, H2 Database


### DB 관련 참고사항
* test 용 프로젝트이므로 간단한 In-memory DB 인 H2 사용
* 어플리케이션 구동 후, H2 Console 로 접속 (http://localhost:8080/user-management)
* spring.jpa.hibernate.ddl-auto 를 create 옵션을 주었기 때문에 어플리케이션 구동시, @Entity 테이블 Drop + Create
* ddl 관련 sql 문을 별도로 참고하고 싶다면? 
  * resources dir 하위에 schema.sql 파일 참고 