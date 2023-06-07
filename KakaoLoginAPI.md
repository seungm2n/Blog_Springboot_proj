#### 카카오 API 앱키
456c1872f8d2d15779d10abf7ab796dd

#### Web Domain
http://localhost:8080

#### Redirect URI (Login)
http://localhost:8080/auth/kakao/callback

#### Redirect URI (Logout)
http://localhost:8080/auth/kakao/logout

#### 카카오로부터 받을 정보 : profile정보(필수) , email(선택)

#### 카카오 로그인 요청 주소 (GET)
https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=456c1872f8d2d15779d10abf7ab796dd&redirect_uri=http://localhost:8080/auth/kakao/callback

#### 토큰 발급 요청 주소 (POST) - http body에 데이터를 전달 (5가지)
MIME : Content-type: application/x-www-form-urlencoded;charset=utf-8
https://kauth.kakao.com/oauth/token

grant_type=authorization_code
client_id=456c1872f8d2d15779d10abf7ab796dd
redirect_uri=http://localhost:8080/auth/kakao/callback
code={code}
