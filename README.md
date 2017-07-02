# wssecurity1

This project is used to demo the websocket, using the jwt tocken to control the user login, using the SSL to encript the communication.

Client used to test this server.

https://github.com/hdaerduo/wssecurityclient


refer:

https://github.com/aboullaite/spring-boot-jwt

https://aboullaite.me/spring-boot-token-authentication-using-jwt/


## verify step

Rest Client

1. sent POST message to the server:

/user/register

Body: application/json; charset=UTF-8. 
{
			"userId":10,
			"firstName": "liu",
			"lastName": "bangbang",
		     "email": "gdfddfd@gmail.com"
}

2. sent POST message to server:

/user/login

get the JWT token.

3. sent POST message to server

http://localhost:8080/secure/user/users

Auth: Bearer Token: eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJoZGFlcmR1b0BnbWFpbC5jb20iLCJyb2xlcyI6InVzZXIiLCJpYXQiOjE0OTc0NTIxMDR9.YB1qLHUvlIROlVs1lu7WVoOHMt8JhQeNL0JkYjtecFc

return OK.


## CA and SSL

数字证书原理:

http://www.cnblogs.com/JeffreySun/archive/2010/06/24/1627247.html

* 密钥实体： 公钥、私钥

* 证书： 用来分发公钥。





