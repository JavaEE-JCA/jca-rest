## JCA Rest Inbound/Outbound Resource Adapter

Sample JavaEE 8 jca resource adapter for learning/testing jca connection factory 

#### build and run :     
**TomEE 8**     
`mvn clean compile install ; (cd ear-module/ ; mvn tomee:run)`

**Liberty/OpenLiberty**     
`mvn clean compile install ; (cd ear-module/ ; mvn liberty:run)`

***test :***
```shell script
# POST message to server :
curl -X POST -H "Content-Type: text/plain" --data "Hello dear !" http://localhost:8080/api/test

# GET messages : 
curl -X GET -H "Content-Type: text/plain" http://localhost:8080/api/test
```