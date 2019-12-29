# SprintBootSoap

``` 
 WSDL URL :
http://localhost:8080/soapWS/eligibilityTest.wsdl

XJC Command : xjc -d C:\Users\Nilesh\Desktop\test\output -p com.demo -wsdl C:\Users\Nilesh\Desktop\test\soap.wsdl
```

```
If XSD having same element in multiple files then it will give us error like --> [ERROR] Two declarations cause a collision in the ObjectFactory class.

So in order to resolve this problem do not use -p [package Name] i.e -p com.demo from above command.

--> xjc -d C:\Users\Nilesh\Desktop\test\output -wsdl C:\Users\Nilesh\Desktop\test\soap.wsdl

So it will generate different packages for different namespaces and those packages will have their own 
object-factory and package-info
```

# h2DbDemo 

```
Sprint Boot Demo with H2 db ,JPA and Swagger UI
  
H2 internal database Url

http://localhost:8080/h2-console/


configurations while connecting with above url:
Use below information and click on connect

Driver class : org.h2.Driver

JDBC URL : jdbc:h2:mem:testdb

User     : sa

```

# Swagger API 

```
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>2.9.2</version>
</dependency>

```

# Swagger api DOCS
http://localhost:8080/v2/api-docs


```
But above url is not human readable so swagger UI must be used

<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>2.9.2</version>
</dependency>

```

# Swagger UI URL 

http://localhost:8080/swagger-ui.html
