Feature: Login feature
  @tugas
  Scenario: Post login user with valid parameter
    Given Post login user with valid parameter
    When Post login user request
    Then Status code should be 200 ok
    And Response body should contain token "QpwL5tke4Pnpja7X4"
           