접근을 요청하는 사용자를 주체(Principal)라고 한다.
Authentication 은 자바 시큐리티 Principal 인터페이스를 확장한다.

AuthenticationProvider 는 인증 논리를 처리한다.
기본 구현은 사용자를 찾는 책임을 UserDetailsService 에 위임하고
PasswordEncoder 로 인증 프로세스에서 암호를 관리한다.

인증 관리자가 요청을 인증하면 세부 정보가 보안 컨텍스트에 저장된다.
SecurityContext 에는 보유전략이 3개가 있다.
각 스레드가 각자의 세부 정보를 저장할 수 있거나,
비동기 메서드의 경우 보안 컨텍스트를 다음 스레드로 복사해주거나,
모든 스레드가 같은 보안 컨텍스트를 보게 한다.

HTTP Basic 이용시 실패했을때 응답을 맞춤 구성하려면 AuthenticationEntryPoint 를 구현하면 된다.
양식 기반 로그인으로 구현시 AuthenticationSuccessHandler, AuthenticationFailureHandler 를 이용할 수 있다.