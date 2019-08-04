# Monese
This is a project for Monese Assignment

How to Build ?
==============
1. Go to command prompt
2. Run ```mvn clean install```

Run Application :
=================
1. Go to terminal
2. Run ``java -jar target\Monese-0.0.1-SNAPSHOT.jar``
3. This will start a tomcat server at port 8080

Details : 
=========

Technologies used :
-------------------
1. spring-boot
2. spring-rest
3. spring-jpa
4. h2 (in memory relational database)
5. spring-boot-test
6. junit
7. postman (for calling restful webservices)

Application :
--------------
1. This application currently has 3 endpoints
2. On startup, it will create 2 database tables and would create 2 accounts
``
ACCOUNT_TABLE : Contains account holder's info and balance
TRANSACTION_TABLE : Contains the details of transcation
``
3. To Transfer Money : ``http://<hostname>:<port>/api/send/transferMoney``
Method : ``POST``
Example uri : ``http://localhost:8080/api/send/transferMoney``
Json Payload : 
``
{
	"fromAcctNum":"1",
  "toAcctNum": "2",
	"transferAmount":"70"	
}
``
4. To view balance : ``http://<hostname>:<port>/view/viewBalance?accountId=<account_id>``
Method : ``GET``
Example uri : ``http://localhost:8080/view/viewBalance?accountId=2``

5. To view transaction history of any account : ``http://<hostname>:<port>/view/viewAccountTransactions?accountId=<account_id>``
Method : ``GET``
Example uri : ``http://localhost:8080/view/viewAccountTransactions?accountId=1``


Special Notes
======================
1. Used H2 in memory database for this project so that the user can easily start the project and test. Can be switched to any relational database.
2. Currently just returning sample response. Can be easily transformed to desired output.
