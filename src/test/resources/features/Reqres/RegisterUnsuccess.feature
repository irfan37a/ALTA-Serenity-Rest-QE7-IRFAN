Feature: Register Unsuccess feature
  @tugas
  Scenario: Post register user with invalid parameter
    Given Post register user with invalid parameter
    When Post register user request invalid
    Then Status code should be 400 Bad Request
    And Response body should contain error "Missing password"