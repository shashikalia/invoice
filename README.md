This application is built using Jersey as the controller, Hibernate-JPA to connect to database and MySQL as a back-end.
Get/Post request can be sent from Jmeter to Jersey-resources which interact with back-end data to provide data in the 
form of JSON.
Maven is used as a build tool, so all the unit test cases are validated before build and application can be deployed with
mvn install on apache-tomcat.

Pre-requisites:
1. Maven must be installed to build/run the application.
2. Mysql should be installed on the system.

Steps to build/run:
1. "pkg/DB" directory contains the SQL scripts, in mysql you need to run the "createDB.sql" script.
	mysql>source createBD.sql
	if later you want to remove the database and user you can remove with script "DropDB.sql"
	
2. For building and running the tool please run below script:
	"pkg/bin/run.bat"
	This script first validate the application, create package and then run the application on apache-tomcat.
	
3. if application is successfully deployed on tomcat in step 2, you can test application by below browser URIs:
	http://localhost:8080/sysapi/v1.0/invoices => to get all the invoices 
	http://localhost:8080/sysapi/v1.0/invoices/?customerId=1&month=3 => to get invoice of Month 3
	http://localhost:8080/sysapi/v1.0/invoices/?customerId=1&filter=shop&month=3 => to get shop related invoices
	and so on
	
4. For creating invoices in the system, you need a tool to send Post request like Jmeter, sample test case of
	Jmeter is added in "pkg/jmeter/"
