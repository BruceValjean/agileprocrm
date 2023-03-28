Feature: Create message feature

  User Story: As a user, I should be able to send messages by clicking on Message tab under Active Stream.
  APCRM-16

  @APCRM-331
  Scenario: Verify create message
    Given User in on the main page
    When user clicks message text area

  @APCRM-333
  Scenario: Verify send message
    And user writes "Deneme11" text
    When user clicks message send button
    And user sees the message in the active stream