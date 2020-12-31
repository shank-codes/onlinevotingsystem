
---Online Voting System (VoteHub) README file---


--Introduction--

This is a simple web application called VoteHub which provides an online platform to create custom elections and simplify the voting procedure. The application was developed using Java Spring Framework, specifically Java Spring boot.

--Hardware Requirements--

Any device that can run the Java Virtual Machine (JVM) and a suitable web browser.

--Software Requirements--

-> JDK 1.8 or later
-> Maven 3.2+
-> MySQL version 5.6 or better
-> You can also import the code straight into your IDE using:
	-> Spring Tool Suite (STS), which is available in spring.io

--Setting up the database--

Since the database is not uploaded online, you will have to create one using mysql workbench or terminal commands.

To create a new database, run the following commands at the mysql prompt:

mysql> create database votingsystem; -- Creates the new database
mysql> create user 'springuser'@'%' identified by 'password'; -- Creates the user
mysql> grant all on db_example.* to 'springuser'@'%'; -- Gives all privileges to the new user on the newly created database

'springuser' and 'password' can be changed to your own if needed.
The database name can also be changed to your own.
However, make sure to mention these changes in application.properties file in the project folder.
Path to application.properties: votingsystem/src/main/resources/application.properties

To mention changes in application.properties file change the following lines:

spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/votingsystem
spring.datasource.username=springuser
spring.datasource.password=password

Change the above lines to:

spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/your_database_name
spring.datasource.username=your_user_name
spring.datasource.password=your_password


--Running the application--

To run the application, simply run the main method in the VotingsystemApplication.java file.

Path: votingsystem/src/main/java/com.dbmsproject.votingsystem/VotingsystemApplication.java

The application will run on your local machine in port 8080.

The web application can be used by entering the following url in any browser: http://localhost:8080/


---THE END---









