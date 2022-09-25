UserDetails 스프링 시큐리티에서 사용자를 기술
GrantedAuthority 사용자가 실행할 수 있는 작업을 정의
UserDetailsManager UserDetailsService 를 확장.

UserDetails 를 상속받아서 만들수도 있고 User 빌더 클래스로 인스턴스를 얻을 수 있다.

UserDetailsService 를 상속해서 구현 후 UserDetailsService 빈에 등록

curl -i -u john:12345 http://localhost:8080/hello

사용자 관리에 JdbcUserDetailsManager 사용