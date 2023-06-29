@regression
Feature: Retail Account

  Background: 
    Given User is on retail website
    When User click on Sign in option
    And User enter email 'studenttekschool@tekschool.us' and password 'Sacto123!'
    And User click on login button
    And User should be logged in into Account

 #updateProfile
  Scenario: Verify User can update Profile Information
    When User click on Account option
    And User update Name 'Winniecheung' and Phone '916-111-2222'
    And User click on Update button
    Then user profile information should be updated

  #paymentMethod
  Scenario: Verify User can add a payment method
    When User click on Account option
    And User click on Add a payment method link
    And User fill Debit or credit card information
      | cardNumber       | nameOnCard| expirationMonth | expirationYear | securityCode |
      | 1111222233335527 | Winniecheung    |               9 |           2025 |          256 |
    And User click on Add your card button
    Then a message should be displayed 'Payment Method added successfully'

	#editPaymentMethod
	Scenario: Verify User can edit Debit or Credit card
	When User click on Account option
	And User select the card ending with '5527'
	And User click on Edit option of card section
	And user edit information with below data
	|cardNumber      |nameOnCard|expirationMonth|expirationYear|securityCode|
	|2222333344445555|Winniecheung        |11             |2027          |123         |
	And user click on Update Your Card button
	Then a message should be displayed 'Payment Method updated Successfully'

  #removePaymentMethod
  Scenario: Verify User can remove Debit or Credit card
    When User click on Account option
    And User select the card ending with '2365'
    And User click on remove option of card section
    Then payment details should be removed

  #addNewAddress
  Scenario: Verify User can add an Address
    When User click on Account option
    And User click on Add address option
    And user fill new address form with below information
    |country      |fullName|phoneNumber |streetAddress|apt|city      |state     |zipCode|
    |United States|WinnieCheung     |916-222-3333|333 J Street|719 |Sacramento|California|95814  |
    And User click Add Your Address button
    Then a message should be displayed 'Address Added Successfully'
   
   
	#editAddress    
 	Scenario: Verify User can edit an Address added on account
	When User click on Account option
	And User click on edit address option
	And user fill new address form with below information
	|country      |fullName|phoneNumber |streetAddress|apt|city      |state     |zipCode|
	|United States|Winniecheung      |916-710-6666|5001 Q Street|25 |Sacramento|California|95828  |
	And User click update Your Address button
	Then a message should be displayed ‘Address Updated Successfully’

	#removeAddress
	Scenario: Verify User can remove Address from Account
	When User click on Account option
	And User click on remove option of Address section
	Then Address details should be removed
    
