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

### 数字证书原理:

http://www.cnblogs.com/JeffreySun/archive/2010/06/24/1627247.html

* 密钥实体： 公钥、私钥

* 证书： 用来分发公钥。

### 客户端服务器交互。-- 简要https过程。

客户端和服务器会经过来回交换信息，判断双方的合法性。

1. 服务要证明它拥有私钥

2. 客户端验证证书是合法的。

过程：

*step1： “客户”向服务端发送一个通信请求

“客户”->“服务器”：你好

*step2： “服务器”向客户发送自己的数字证书。证书中有一个公钥用来加密信息，私钥由“服务器”持有

“服务器”->“客户”：你好，我是服务器，这里是我的数字证书 

* step3： “客户”收到“服务器”的证书后，它会去验证这个数字证书到底是不是“服务器”的

“客户”->“服务器”：向我证明你就是服务器，这是一个随机字符串     

“服务器”->“客户”：{一个随机字符串}[私钥|RSA]

*  验证“服务器”的身份后，

“服务器”->“客户”：{OK，已经收到你发来的对称加密算法和密钥！有什么可以帮到你的？}[密钥|对称加密算法]

“客户”->“服务器”：{我的帐号是aaa，密码是123，把我的余额的信息发给我看看}[密钥|对称加密算法]

“服务器”->“客户”：{你好，你的余额是100元}[密钥|对称加密算法]


### 证书的构成和原理 - 如何证明这是一个合法的证书？

#### 证书的构成和原理

(指纹以及指纹算法)：用来保证证书的完整性

微软等公司会根据一些权威安全机构的评估选取一些信誉很好并且通过一定的安全认证的证书发布机构，把这些证书发布机构的证书默认就安装在操作系统里面了，并且设置为操作系统信任的数字证书

#### 向证书的发布机构去申请证书

1. 向一个证书发布机构"SecureTrust CA"申请一张证书。

2. 当客户端访问服务器，服务器将证书发给客户端。

3. 客户端发现是"SecureTrust CA"发布的证书，会到系统中找到"SecureTrust CA"的证书

4. 用"SecureTrust CA"的证书的公钥提取证书里的指纹信息，并和自己计算出来的指纹进行比对，如果一致，那么收到的证书是可信的。



