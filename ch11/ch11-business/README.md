맞춤형 인증과 권한 부여를 구현할 때는 Authentication Provider, 
AuthenticationManager, UserDetailsService 등이 있다.

토큰은 사용자를 위한 식별자이며 생성 후 서버가 인식할 수 있으면 
어떤 구현이든 이용할 수 있다.

JWT 토큰은 서명하거나 완전히 암호화할 수 있다. 서명된 JWT 토큰을 
JWS(JSON Web Token Signed)라고 하며 세부 정보가 완전히 암호화된 토큰을 
JWE(JSON Web Token Encrypted)라고 한다.

토큰이 길수록 서명하거나 암호화하는데 시간이 많이 걸린다. 
헤더로 보내기 때문에 각 요청에 추가되는 데이터가 늘어나고 성능에 영향을 준다.

다단계 인증(MFA)는 사용자가 리소스에 접근할 때 여러번 다른 방법으로 인증하도록 요청하는 전략이다.