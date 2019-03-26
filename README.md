# a3kexcercise


Quick programming task fr a3k. Stack: Java, Spring, JS, jQuery, Thymeleaf, HTML.
By far the most challenging part was making AJAX work, since I have no prior experience with front-end.

In order to run code you should have an existing empty MySQL DB running on port 3306 and a user with priveleges for it.
Create prequisites following instructions:
```sql
CREATE DATABASE colorsdb;
CREATE USER 'a3kcolors'@'localhost' IDENTIFIED BY 'a3kcolors';
GRANT ALL PRIVILEGES ON colors.* TO 'a3kcolors'@'localhost';
```
Clone the project and you're good to go.
Tables would be created automatically when you run the code.
Page deploys on localhost:8080
