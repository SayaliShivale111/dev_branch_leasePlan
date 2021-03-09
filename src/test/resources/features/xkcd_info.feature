Feature: Get response of XKCD API for info.json
 
  Scenario: xkcd response schema should match with specification
    Given I call the info json details endpoint for title "Mars Rovers"
    When title details should be retrieved
    Then the schema should match with the specification defined in "xkcd_info.json"

  Scenario: Should be able to get title details
    Given I call the info json details endpoint for title "Mars Rovers"
    When title details should be retrieved
    Then title should be "Mars Rovers"

  Scenario: Empty response should be returned while searching for a non-existent comic id num
    When I call the get num details endpoint for non-existent user "2455"
    Then empty or page not found response should be returned
