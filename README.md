# Java Spring Boot RDBMS sample project with unit testing setup

This is sample project to showcase how we can setup our project with unit tests for RDBMS backend.

While writing and running unit test one approach is to mock all database calls. However, I see two challenges with it 1) my database queries is not tested and 2) sometime it becomes difficult to write such mocked test.

After hearing to Martin Fowler, Kent Beck and DHH. My take is if my test is fast and easy to write/manage, it is okay to write some tests that are hitting databases so I can test my queries and see all working.

However, now comes the next challenge, how the hell do I run Oracle or DB2 while running my unit tests. Embedded databases like H2 and HSQLDB comes to rescue for testing.

In this example I use H2 database with FlywayDB to showcase how we can do unit testing with hitting database and run very quickly. This is just one sample and I encourage more pure unit tests for logic and other parts of the code. However, this approach can help you to test your repo layer (queries) and save you from mocking hell.




