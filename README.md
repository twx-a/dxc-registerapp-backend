# dxc-registerapp-backend
basic register app.
Simple Documentation:

How to use?
- Uses apache tomcat. Run via eclipse or intelliJ
- Port opens at default port of 8080 http.
Routes:
1. localhost:8080/api/users
2. localhost:8080/api/register
3. localhost:8080/api/login

Formats accepted for routes:
1. Required: None
2. Required: Email, Password, FirstName. Not required: LastName, Manager(Default Value of 'N')
3. Required: Email, Password

# Warnings
This app is not secure. Spring security is not in place so passwords are stored in plain text via db.

# todo
Date of registration for users.
Spring Security for passwords.