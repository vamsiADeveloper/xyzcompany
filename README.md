# xyzcompany
This applications is to calculate rewards for each month based on the amount of purchases made for a certain organization. 
Runs in Springboot with inmemory H2 database Views are added using Spring MVC, have used JQuery for ajax calls and basic validations. 

After checking out the project - Run XyzcompanyrewardsApplication as a Java application throuhg IDE.( I have used Eclipse)

-Once the application is up and running you may use http://localhost:8080 to view the screens. Enter amdin/admin as user name and password 
on Login screen - admin/admin are saved in the respective table in the inmemomory DB.

-This application will pull 3 customers from Inmemory Database for the XYZ company showing total level records for each month and a consolodate rewards earned for each customer. You can click on View Details on each row to look at the detailed level line items.

- Inorder to view H2 console after starting the app, login using http://localhost:8080/h2-console/. 
IF any issue with logging into H2 Console - retry using JDBC URL jdbc:h2:mem:testdb

- Created a rest point that can be access through JQuery Ajax calls and you can also use this rest point to view Reward Details for CUSTOMERA - http://localhost:8080/customerRewardDetails/CUSTOMERA you can also use CUSTOMERB, CUSTOMERC through postman.
