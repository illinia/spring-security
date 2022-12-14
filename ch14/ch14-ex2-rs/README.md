리소스 서버는 사용자 리소스를 관리하는 스프링 구성요소다.

리소스 서버는 권한 부여 서버가 클라이언트를 위해 발행한 토큰을 검증할 방법이 필요하다.

리소스 서버가 토큰을 검증하는 한가지 옵션은 권한 부여 서버를 직접 호출하는 것이다.
이 방식은 권한 부여 서버에 부담을 줄 수 있어 피한다.

리소스 서버가 토큰을 검증할 수 있도록 데이터베이스 참조 아키텍처를 구현할 수 있다.
권한 부여 서버와 리소스 서버가 토큰을 관리하는 같은 데이터베이스에 접근한다.

데이터베이스 참조는 리소스 서버와 권한 부여 서버간의 종속성을 없애지만
토큰을 지속하는 데이터베이스를 추가해야 하며 병목 지점이 되어 성능이 저하될 수 있다.

JdbcTokenStore 는 데이터베이스 엑세스 토큰과 갱신 토큰을 지속하는데 사용가능한 TokenStore 구현체다.