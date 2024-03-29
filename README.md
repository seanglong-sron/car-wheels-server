## How to install and run

create a database in postgreSQL

### create table
`
CREATE TABLE public.car (id serial4 NOT NULL,"name"text NOT NULL,wheels int4 NOT NULL
);
`

### update application.properties to your db

spring.datasource.url=YOUR DB CONNECTION\
spring.datasource.username=YOUR DB USERNAME\
spring.datasource.password=YOUR DB PASSWORD


`mvn clean install`

`mvn spring-boot:run`