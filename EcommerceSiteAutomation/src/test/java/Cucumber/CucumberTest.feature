#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Order placing
  I want to use this template for my feature file

Background:
  Given I am on the landing page

@tag2
Scenario Outline: Make the order for Women jacket
  Given Logged in with username <name> and password <password>
  When I select the jacket
  And I click on Add to cart
  And I add the shipping address <Fname> <Lname> <Address> <City> <State> <PostCode> <Country> <phone>
  Then I verify the payment
  And Check for confirmation message


Examples: 
  | name                          | password | Fname  | Lname    | Address        | City   | State  | PostCode | Country       | phone       |
  | isurujayakody123@gmail.com    | Abc@12345 | Isuru  | Jayakody | Queens Street  | London | Alaska | N6G2N1   | United States | +226345234  |
  | anshika@gmail.com             | Abc@12345 | Shanika| Jayakody | Trevor Street  | London | Alaska | N6G2N1   | United States | +226345234  |


 
