# Selenium
* This repo contains practicing Selenium framework using Java for web testing purposes.

# Installation
1. Install Java.
2. Install Maven.
3. Install editor (eclipse, VS code,..).
4. Add TestNG and Selenium Maven dependancies in POM file.
5. Install drivers (chromedriver, geckodriver, ..).
6. Then clone the repo: git clone https://github.com/hala-samir/web-ecommerce

# The approach used in testing and  why this tech stack:
### Page Factory Model
The used approach here is page object model (POM) and page factory. POM can offer smooth handing.
If there are changes in UI have been done so, a tester will fix only the page object classes to updated
the changed element instead of fixing a changed element in each test uses it(if POM is not used).
### Maven
Maven is also used to manage a project's build, reporting and documentation from a central piece
of information and a project will be easy shared without having to lots of manual libararies downloading.
### TestNG
TestNG simplifies the way the tests are coded. There is no more need for a static main method in our tests. The sequence of actions is regulated by easy-to-understand annotations that do not require methods to be static.
TestNG generates a proper report, and you can easily come to know how many test cases are passed, failed, and skipped. You can execute the failed test cases separately.
### Selenium
Selenium supports automation of all the major browsers in the market through the use of WebDriver. WebDriver is an API and protocol that defines a language-neutral interface for controlling the behaviour of web browsers. Each browser is backed by a specific WebDriver implementation, called a driver. The driver is the component responsible for delegating down to the browser, and handles communication to and from Selenium and the browser.