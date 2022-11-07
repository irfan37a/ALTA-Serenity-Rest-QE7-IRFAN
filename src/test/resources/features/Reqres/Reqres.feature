Feature: Reqres Feature
  @Latihan
  Scenario Outline: Get list user with valid parameter page
    Given Get list user with valid parameter page <page>
    When Send get list user request
    Then Status code should be 200 ok
    And Response body page should be <page>
    And Validate get list user json chema
  Examples:
    | page |
    | 1    |
    | 2    |
  @Latihan
  Scenario: Post create new user with valid json
    Given Post create user with valid json
    When Send post create user request
    Then Status code should be 201 Created
    And Response body should contain name "irfan herianto" and job "QA"
    And Validate create user json schema

  @Latihan
  Scenario Outline: Put update user with valid json
    Given Put update user with valid json with id <id>
    When Send put update user request
    And Status code should be 200 ok
    And Response body should contain name "irfan Update" and job "QA Update"
    And Validate put update json schema
  Examples:
    | id |
    | 1  |
    | 2  |
  @Latihan
  Scenario Outline: Delete user with valid id
    Given Delete user with <id>
    When Send delete user request
    Then Status code should be 204 No COntent
  Examples:
    | id |
    | 2  |