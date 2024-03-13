Feature: add two random products
  Scenario: add two random products to the cart
    Given open Home Page, Hover On Storage
    When add Two Random Products
    Then compare The Two products And Check The Calculated Total Price