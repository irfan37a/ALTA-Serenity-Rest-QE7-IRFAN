Feature: Single user feature
  @tugas
  Scenario Outline: Get single user with valid parameter id
    Given Get single user with valid parameter id <id>
    When Send get single user request
    Then Status code should be 200 ok
  Examples:
    | id |
    | 1  |
    | 2  |

  @tugas
  Scenario Outline: Get single user with invalid parameter id
    Given Get single user with invalid parameter id "<id>"
    When Send get single user request
    Then Status code should be 404 Not Found
    Examples:
      | id     |
      | 20     |
      | 1!@#$% |

