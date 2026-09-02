
Feature: Booking Functionality
  @Booking
  Scenario Outline: Successful Booking

    Given the user is on the Booking page
    When the user selects the source and destination locations
    And the user selects the journey date
    Then the user should be able to book the ticket

    When the user need to select flight option
    # And the user selects the "<source>" and "<destination>" locations for flight
    And the user selects flight locations from excel

    And the user selects the details about the journey
    Then the user able to book the flight
  
  Examples:
      | source   | destination | 
      | Kolkata  | Mumbai    | 