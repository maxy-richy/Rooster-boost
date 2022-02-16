  ---- Authentication
Use a login for located at 127.0.0.1:8080/login
  
There are predefined credentials:
admin : admin

In order communicate with the app you need a cookie returned by the login request, see screenshot.
![alt text](screen.png)

Fot your convenience there is a Postman collection attached to this project.

---- Data
As for database, you can populate it from a file called academy_awards.csv if you run the app in `populate` profile of Spring.

User data also comes from the database, see schema.sql