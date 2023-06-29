@regression
Feature: Retail SignIn

	Background:
	Given User is on retail website
  When User click on Sign in option

#verifySignIn
	Scenario: Verify user can sign in into Retail Application
  And User enter email 'student1@tekschool.us' and password 'Tek@School1'
  And User click on login button
  Then User should be logged in into Account
  
 #createNewAccount   
	Scenario: Verify user can create an account into Retail Website
	And User click on Create New Account button
	And User fill the signUp information with below data
	|name   |email                   |password  |confirmPassword|
	|studenttek|studenttekschool@tekschool.us|Sacto123!|Sacto123!    |
	And User click on SignUp button
	Then User should be logged into account page