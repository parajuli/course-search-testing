Feature: Search for a course on TAFE NSW website

  Scenario: Search for a course and apply the "On campus" delivery filter
    Given I am on the TAFE NSW website
    When I search for a course with the keyword "Advanced Barista Skills"
    And I click the search button
    Then I should see the "Advanced Barista Skills" course in the search results
    When I apply the "delivery" filter by setting it to "On campus"
    Then I should see that the filter has been correctly applied to the chosen course