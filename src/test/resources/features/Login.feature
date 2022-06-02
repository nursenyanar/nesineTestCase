Feature: nesine.com Home Page

  @Chrome
  Scenario: nesine.com case study
    Given Go to nesine home page
    And Check login button
    When Login with a valid username and password
    When 'Popular bet' button is clicked
    And  'Popular bet' page url check
    When Go to football tab
    When Code and number of plays is checked
    And Log out by clicking on my account button

  @Firefox
  Scenario: Popular bets volleyball tab
    Given Go to nesine home page
    When 'Popular bet' button is clicked
    When Go to volleyball tab
    And Page tab check




