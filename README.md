# ecommerce_garwan

Release 1.0
-api for product
-api for list of products with filter request params and paging.
--Required:
postgree DB
Db schema and basic data will be automatically initialized on start up

in resources/application.properties change:
spring.datasource.username=postgres   -- your db usernmae
spring.datasource.password=root       -- your db password

For deployable war file run maven clean install (mvn clean install)


http://localhost:8080/products/{id}  - for product

http://localhost:8080/products       - list of products

filter: http://localhost:8080/products?name=SomeNameOfProduct?min=50


Release 2.0 - comming soon :) 
