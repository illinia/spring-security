OAuth2 프레임워크는 사용자 대신 리소스에 접근할 수 있게 한다.

앱이 액세스 토큰을 얻기 위해 사용할 수 있는 다양한 흐름을 그랜트라고 한다.
1. 승인 코드 그랜트 유형은 사용자가 직접 권한 부여 서버에서 인증하여 클라이언트가 액세스 토큰을 얻을 수 있게 해준다.
사용자가 클라이언트를 신뢰하지 않고 클라이언트와 자격 증명을 공유하기를 원하지 않을 때 적합.
2. 암호 그랜트 유형은 사용자가 자신의 자격 증명을 클라이언트와 공유한다고 가정한다.
클라이언트를 신뢰할 수 있는 경우에 적합
3. 클라이언트 자격 증명 그랜트 는 클라이언트가 자격 증명으로만 인증하여 토큰을 얻는다.
클라이언트가 사용자의 리소스가 아닌 리소스 서버의 엔드포인트를 호출해야 할 때 선택

스프링 시큐리티는 ClientRegistration 인스턴스를 이용해 권한 부여 서버에서 클라이언트의 등록을 나타낸다.

스프링 시큐리티 OAuth2 구현에서 특정 클라이언트 등록을 찾는 책임이 있는 구성 요소를
ClientRegistrationRepository 라고 한다.