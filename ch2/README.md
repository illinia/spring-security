curl http://localhost:8080/hello
결과 401

echo -n user:7beef90e-ba60-4b60-aec5-ff4ae5380d73 | base64
username:password 를 Base64 로 인코딩

curl -H "Authorization: Basic dXNlcjo3YmVlZjkwZS1iYTYwLTRiNjAtYWVjNS1mZjRhZTUzODBkNzM=" http://localhost:8080/heelo
호출시 인코딩 문자열을 Authorization 헤더의 값으로 사용 가능

openssl req -newkey rsa:2048 -x509 -keyout key.pem -out cert.pem -days 365
개인키 key.pem, 공개 인증서를 담은 cert.pem 두 파일 생성

openssl pkcs12 -export -in cert.pem -inkey key.pem -out certificate.p12 -name "certificate"
첫 번째 명령이 생성한 두 파일을 입력으로 받고 자체 서명 인증서 생성

certificate.p12 파일을 프로젝트 resources 폴더에 복사, application.properties에 server.ssl 속성 값들 추가

curl -k https://localhost:8080/hello
-k 옵션으로 인증서 신뢰성 테스트 생략

스프링 시큐리티 기본구성 재정의(Authentication Provider 인증 공급자)
UserDetailService : 인증 프로세스에 이용한다.
PasswordEncoder : 암호를 인코딩하고, 암호가 기존 인코딩과 일치하는지 확인. UserDetailService 를 재정의 했으면 같이 정의해줘야함

인증 공급자를 다른 방법으로 구성 설정하기
WebSecurityConfigurerAdapter 를 상속받은 클래스에서 configure(AuthenticationManagerBuilder) 메서드를 오버라이드 해서 사용할 수 있다.

한 클래스가 하나의 책임을 갖도록 선언한 결과 
UserManagementConfig 에서 AuthenticationProvider 역할을 맡게 한다.