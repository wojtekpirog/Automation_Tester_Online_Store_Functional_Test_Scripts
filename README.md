# Automation_Tester_Online_Store_Functional_Test_Scripts

## Description
This repository contains the source code of a script that tests the procedures of adding and deleting user account information and ordering a product in an online store. Both tests were performed on a generic user account that was previously created manually here: https://mystore-testlab.coderslab.pl. The business requirements for both test scenarios are defined in their respective `.featue` files.

## Tools and technologies
The automation test scripts present in this repository were created using the following tools and technologies:
- Java
- Gherkin
- Selenium WebDriver
- Cucumber Framework
- Log4J
- AShot API

## Test scenarios
- **Test scenario 1 - User can and a new address and then delete it**
  1. Log in to the previously created user account.
  2. Click on the `Addresses` button after logging in. Now the address is: https://mystore-testlab.coderslab.pl/index.php?controller=addresses
  3. Click on the `+ Create new address` link to go to the address creation form.
  4. Fill in the address creation form with data previously specified in an `Examples` table in the `.feature` file for this test scenario.
  5. Check if the address details are correct.
  6. Delete the newly created address by clicking the `delete` button.
  7. Check if the deletion operation was successful

- **Test scenario 2 - User can purchase a specific product in an online store and then see the purchase confirmation**
  1. Log in with the same user from `Test scenario 1`.
  2. Select a specific product (here: "Hummingbird Printed Sweater") and check if it has a 20% discount.
  3. Select any product size (here, available product sizes are S, M, L, XL). The size option selected by default is M.
  4. Select any number of pieces of the product. The default number of pieces in this test is 5.
  5. Add product to cart.
  6. Proceed to checkout.
  7. Confirm the desired delivery address. For the sake of this specific test scenario, I created a generic address manually.
  8. Select order pickup method (shipping method) - here, I selected the option "Pick up in-store".
  9. Select payment method - here, I selected the option "Pay by check".
  10. Select the checkbox to agree to the terms of service, and then place the order.
  11. Take a screenshot containing the order confirmation and its total amount and save it on your computer.
