# Java Spring Boot RDBMS sample project with unit testing setup

This is sample project to showcase how we can setup our project with unit tests for RDBMS backend.

While writing and running unit test one approach is to mock all database calls. However, I find challenging with it,
1. with mocking database queries are not tested
2. sometime it becomes difficult to write such mocked test.

My take is, if my test is fast, easy to write & manage, robust and points broken code, it is okay to write tests that are hitting databases and I can test my queries and achieve automated testing. I can call it unit or integration tests, no problem. My principle is very simple, all automated tests should run on every check-in.

However, now comes the next challenge, how the hell do I run Oracle or DB2 while running my unit tests. Embedded databases like H2 and HSQLDB comes to rescue for testing. H2 database has feature called compatibility modes which helps to run same production DDL scripts in unit tests.

In this example I use H2 database with FlywayDB to showcase how we can do unit testing with hitting database and run very quickly. This is just one sample and I encourage more pure unit tests for logic and other parts of the code. However, this approach can help you to test your repo layer (queries) and save you from mocking hell.

While building API, should avoid exposing the core entity and hence I prefer using wrapper view objects. Controller can decide which view to render and based on that it returns the value.


Note:
1. I have not used JPA considering example for REST service and unit testing. Please use JPA if you need to.
2. FlywayDB is used on for test database, however I would strongly recommend using it for all environments including Production.






