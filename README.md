# wssecurity1

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
			"firstName": "huang",
			"lastName": "tingmou",
		     "email": "hdaerduo@gmail.com"
}

2. sent POST message to server:

/user/login

get the JWT token.

3. sent POST message to server

http://localhost:8080/secure/user/users

Auth: Bearer Token: eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJoZGFlcmR1b0BnbWFpbC5jb20iLCJyb2xlcyI6InVzZXIiLCJpYXQiOjE0OTc0NTIxMDR9.YB1qLHUvlIROlVs1lu7WVoOHMt8JhQeNL0JkYjtecFc

return OK.


