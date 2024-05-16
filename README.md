# Dmoney-Rest-Assured
# Dmoney API Test Automation REST Assured
This repository contains automated test scripts for the Dmoney API using Rest Assured. The test scripts automate various activities outlined in the task description.

# Setup Instructions
Follow these steps to set up and execute the automated tests:

# Usage
1.Navigate to the project directory.

2.Run the following command to install dependencies:

3.Execute the test scripts by running: gradle clean install

# Update the config.properties File
## Set the baseUrl:

 1.Set the baseUrl to the URL of the Dmoney API.
# Update the partnerKey and token:

 1.Update the partnerKey and token for authentication.
# Prepare Necessary Data
## Create a JSON File:

 * Create a JSON file containing the required information for creating customers and agents as outlined in the task description.
# Save the JSON File:

* Save the JSON file in the project directory.
# Execute the Tests
## Execute the Tests:

Run the automated test suite to execute the tests against the Dmoney API.
Ensure that the tests are executed successfully without any failures.
gradle clean test
# Test Scenarios
## The automated tests cover the following scenarios:

1. Login by admin.<br>
2. Creation of 2 new customers and an agent.<br>
3. Transfer of 2000 tk from the System account to the newly created agent.<br>
4. Deposit of 1500 tk to a customer from the agent account.<br>
5. Withdrawal of 500 tk by the customer to the agent.<br>
6. Money transfer of 500 tk to another customer.<br>
7. Payment of 100 tk to a merchant (01686606905) by the recipient customer.<br>
8. Verification of the balance of the recipient customer.
# Generating Allure Report
## After running the tests, execute the following command to generate the Allure report:

allure generate allure-results --clean -output
allure serve allure-results
# ScreenShot
<img width="923" alt="allure1" src="https://github.com/MdMithun14/API-Rest-Assure/assets/159123567/04c39ce7-f605-4ed3-beb9-a1c00803e617">

<img width="923" alt="allure 2" src="https://github.com/MdMithun14/API-Rest-Assure/assets/159123567/56bbe86a-c421-4bda-a7b6-0283a3e318ec">
