# Spring JPA example

### Prerequisites

* JDK 1.6+
* Maven 3.0+
* MYSQL (latest version)
* MYSQL Workbench (latest version)

### How to Run
Execute createtables.sql in mysql workbench or mysql command window

Open a command prompt, cd to the same directory as the top level pom and run: mvn clean package

Execute Application.java as a java application.  Execute below sql in workbench and you should see vikrant, james and david created in person table with addresses

use test;

select * from person;

select * from address;


