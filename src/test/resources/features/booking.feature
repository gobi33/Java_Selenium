
Feature: Booking Functionality
  @Booking
  Scenario: Successful Booking

    Given the user is on the Booking page
    When the user selects the source and destination locations
    And the user selects the journey date
    Then the user should be able to book the ticket
