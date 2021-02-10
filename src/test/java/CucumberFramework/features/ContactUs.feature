# Created by Alexandru at 08-Feb-21
Feature: Submit data using the contact us form


	Scenario: Submit valid data via contact form
		Given I access website contact us form
		When I enter a valid firstname
		And  I enter a valid lastname
			| woods | jackson | jones |
		And I enter a valid email address
		And I enter comments
			| example one | example two |
		And submit the data
		Then the data is successfully submitted