# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

# Spring Boot Restful API for Redis(Memory DB), Mysql Connect Test

## 준비 사항
MY-SQL Workbench, Redis Local 설치

## 실행 순서 
1. SpringBootTestApplication을 실행 -> 톰켓 내장입니다. 
2. Web : Localhost:8080/ping, getRedis, getMysql 확인  


## Restful API StatusController 
### ping
  -> Restful API Status Check.
### getRedis
  -> Lettuce Connect used and Redis(Memory DB) data set/get.
### getMysql 
  -> My-SQL Connect used and Object get. 
 
