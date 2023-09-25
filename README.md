# dxc-registerapp-backend
basic register app.
Bootstrapped using: https://start.spring.io/
# Dependancies:
Java version: JDK 17
Springboot version: 3.1.4
Tool: Maven
Dependancies in pom.xml / added from " https://start.spring.io/ "
1. Spring Web
2. Spring Data JPA
3. H2 Database
4. Spring Security | this is commented out.

# Simple Documentation:
How to use?
- Uses apache tomcat. Run via eclipse or intelliJ
- Port opens at default port of 8080 http.
Routes:
1. localhost:8080/api/users
2. localhost:8080/api/register
3. localhost:8080/api/login
4. localhost:8080/h2-console/

Formats accepted for routes:
1. Required: None
2. Required: Email, Password, FirstName. Not required: LastName, Manager(Default Value of 'N')
3. Required: Email, Password
4. db settings
    - spring.datasource.url=jdbc:h2:mem:testdb
    - spring.datasource.username=sa
    - spring.datasource.password=

# Warnings
This app is not secure. Spring security is not in place so passwords are stored in plain text via db.

# todo
Date of registration for users.
Spring Security for passwords.