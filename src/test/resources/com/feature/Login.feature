Feature: Login into admin panel
 
@Login_into_admin
Scenario: Test login with valid credentials into admin panel
Given Open the chrome and start application
When I enter valid username and valid password
Then user should be able to login successfully