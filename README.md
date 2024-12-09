# Contact List - testing

This README provides information and guidelines for testing the Contact List application.

## Table of Contents
- [Introduction](#introduction)
- [Testing Scope](#testing-scope)
- [Prerequisites](#prerequisites)
- [Test Plan](#test-plan)
- [Test Execution](#test-execution)
- [Contributing](#contributing)
- [Resources](#resources)
- [Contact Information](#contact-information)

## Introduction
The purpose of this documentation is to guide testers in performing effective testing on the Contact List application. By following the guidelines provided, testers can ensure the quality and reliability of this module.

## Testing Scope
The testing will encompass the following areas:
- Functional testing
- Smoke testing
- API testing

## Prerequisites
Before testing the software, ensure the following prerequisites are met:

- Supported web browsers and versions:

    Chrome Version 131.0.6778.109

    Edge Version 131.0.2903.86

- Credentials for sign up and login

## Test Plan
Testing strategy and objectives:

- The goal of this testing is to validate sign up and login to Contact List app and validate add new contact option.
- These tests are created for covering the signup to the app, login with invalid credentials, login with valid credentials and adding new contact.
- Types of tests to be performed
- Testing methodology white-box and black-box
- White-box tests are executed as a Maven project using TestNG and Selenium dependencies
- Black-box tests are executed as a Postman collection

## Test Execution
To execute the white-box automation test cases, follow these steps:

1. Open Terminal
2. Enter mvn clean verify command into terminal
3. Pass parameters -D (browser, firstName, lastName, email, password) values along with the command above
4. Press enter to start execution of test cases

## Contributing
To contribute to the testing efforts, follow these steps:

1. Fork the repository and clone it to your local machine.
2. Create a new branch for your test cases or improvements.
3. Commit and push your changes to your branch.
4. Submit a pull request with a detailed description of your changes.

## Resources

- [Testing Framework](#src/test/resources/testng.xml)

## Contact Information
For any questions, feedback, or issues related to testing, feel free to contact me:

- Email: lejla_m96@live.com

I appreciate your involvement in the testing process and value your contributions.