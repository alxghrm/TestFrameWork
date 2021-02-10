# Created by Alexandru at 08-Feb-21
Feature: Products
  # Enter feature description here

	Scenario Outline: Validate promo code alert is visible when accessing the link
		Given user navigates to "<url>" website
		When user clicks on "<button>" button
		Then user should be presented with a promo alert
		Examples:
			| url                                                            | button                   |
			| http://webdriveruniversity.com/Page-Object-Model/products.html | container-special-offers |