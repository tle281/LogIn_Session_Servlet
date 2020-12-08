# LogIn_Session_Servlet

Code for Login and Logout Session with Java Servlet, JSP and MySQL
1. Create database 'session' and table 'users'
  > create database session;
  
  > use session;
  
  > CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `fullname` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

2. Run servlet on Tomcat
