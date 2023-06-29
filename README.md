# BuggyCarTestAutomation
Created automation test for Registration Page &amp; Login Page. User will be able to Register, Login &amp; then vote for Sports car.

Automation Testing using TestNG, and Selenium for Buggy Cars Rating (https://buggy.justtestit.org/).

Pre-requisites
Eclipse IDE
Maven Project using TestNG & Selenium
RestAssured for API Testing
Git

Setup
Clone the repository to your local machine
Open Eclipse and Import the project
Run the project

There are three files
1) LoginPage - User is able to Login with valid credentials and then vote for sports car.
2) Registration - User is able to regiter as new user, this file also include password vaildation methods
3) RestAssuredAPI - Checking if Buggy Car Rating website is available with status code as 200 using GET https protocol.

Login Page
1) Implement test for Login Method to check successful login.
2) Implement test to validate whether user has voted for the sports car, since user have already voted for sports car, user will be unable to vote for the same car.

Registration
1) Implement test for Registration and then call Login Method to check successful login.
2) Enters correct Credentials check if the user's first name is correctly displayed once logged in (i.e. Hi Firstname!)
3) Test whether password shows the error messages when password doesn't meet the requirement (Upper Case has not been specified).
4) Test whether password shows the error messages when password doesn't meet the specification (Special character has not been specified).
5) Duplicat Profile not allowed Test whether username already exixts.

RestAssuredAPI 
1)As API documentation is not available, so checking if site is available using GET https protocol and validate the status code is 200.
