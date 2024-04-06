E2E positive test for https://www.saucedemo.com/: adding an item to the cart and checking out as a standard user 

Credentials:
username = standard_user
password = secret_sauce

Steps:
1. Opening  https://www.saucedemo.com/;
2. Loging in using the credentials above;
3. Checking that Product Page is opened;
4. Sorting items by price: low -> high;
5. Adding the first item (index = 0) to cart;
6. Navigating to cart;
7. Checking that the cart pages is opened;
8. Navigating to checkout;
9. Checking that the personal information page is opened;
10. Filling in the form using data from config.properties and pressing "Continue" buttin;
11. Checking that the overview page is opened;
12. Pressing "Finish" button;
13. Checking that the complete page is opened;
14. Checking that the header of the page equals "Thank you for your order!";
15. Pressing "Back home" button;
