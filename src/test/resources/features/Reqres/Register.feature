Feature: Register feature
  @tugas
  Scenario: Post register user with valid parameter
    Given Post register user with valid parameter
    When Post register user request
    Then Status code should be 200 ok
    And Response body should contain id 4 and token "QpwL5tke4Pnpja7X4"
