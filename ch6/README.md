제품 정보, 사용자는 데이터베이스에 저장하고 사용자의 암호는 bcrypt, scrypt 로 해시된다.
암호화 유형은 user 테이블의 한 열에 저장되고 두번째 테이블에 사용자의 권한이 저장된다.

1. 암호 인코더 빈 등록
2. User, Authority 엔티티 정의, 스프링 데이터 리포지토리 인터페이스 정의
3. UserDetails 인터페이스 구현, UserDetailsService 인터페이스 구현
4. 맞춤 인증 논리 구현 위해 AuthenticationProvider 인터페이스 구현
5. AuthenticationProvider authenticate 에서 인증 되었을 경우 UsernamePasswordAuthenticationToken 으로 반환하게 함
6. WebSecurityConfigurerAdapter 상속해서 AuthenticationProvider 를 오버라이드한 configure 메서드에서 등록
7. 컨트롤러 등록, 인증된 사용자 정보 가져와서 렌더링

문제점과 해결
1. 스프링 부트에서 sql 쿼리들이 실행 안되는 문제 있었음
   1. spring.jpa.defer-datasource-initialization=true
   2. spring.datasource.initialization-mode=always
2. 책에 나온 쿼리들에 문제들이 있어서 수정함