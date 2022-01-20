$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("DemoWebsite.feature");
formatter.feature({
  "line": 2,
  "name": "Lambda Test Checkers",
  "description": "",
  "id": "lambda-test-checkers",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@lambdatest"
    }
  ]
});
formatter.before({
  "duration": 437666589,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Valid Login",
  "description": "",
  "id": "lambda-test-checkers;valid-login",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "I go to Homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I should see correct title page for Homepage",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "I login with valid credential",
  "keyword": "And "
});
formatter.match({
  "location": "LambdaTestSteps.givenIGoToHomepage()"
});
formatter.result({
  "duration": 78825094239,
  "status": "passed"
});
formatter.match({
  "location": "LambdaTestSteps.assertPageTitleHomepage()"
});
formatter.result({
  "duration": 536168885,
  "status": "passed"
});
formatter.match({
  "location": "LambdaTestSteps.loginValidCred()"
});
formatter.result({
  "duration": 27158902411,
  "status": "passed"
});
formatter.after({
  "duration": 83217,
  "status": "passed"
});
formatter.before({
  "duration": 480621366,
  "status": "passed"
});
formatter.scenario({
  "line": 9,
  "name": "Invalid Login",
  "description": "",
  "id": "lambda-test-checkers;invalid-login",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 10,
  "name": "I go to Homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "I should see correct title page for Homepage",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "I login with invalid credential",
  "keyword": "And "
});
formatter.match({
  "location": "LambdaTestSteps.givenIGoToHomepage()"
});
formatter.result({
  "duration": 4951038188,
  "status": "passed"
});
formatter.match({
  "location": "LambdaTestSteps.assertPageTitleHomepage()"
});
formatter.result({
  "duration": 432879705,
  "status": "passed"
});
formatter.match({
  "location": "LambdaTestSteps.loginInvalidCred()"
});
formatter.result({
  "duration": 22701076241,
  "status": "passed"
});
formatter.after({
  "duration": 26377,
  "status": "passed"
});
formatter.before({
  "duration": 430572828,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Checkout item",
  "description": "",
  "id": "lambda-test-checkers;checkout-item",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 15,
  "name": "I go to Homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "I login with valid credential",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "I add products to cart",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "I proceed to checkout without checking TOC",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "I should see TOC warning",
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "I proceed to checkout after checking TOC",
  "keyword": "When "
});
formatter.step({
  "line": 21,
  "name": "I should be at payment section",
  "keyword": "Then "
});
formatter.step({
  "line": 22,
  "name": "I logout from website",
  "keyword": "And "
});
formatter.match({
  "location": "LambdaTestSteps.givenIGoToHomepage()"
});
formatter.result({
  "duration": 4504054013,
  "status": "passed"
});
formatter.match({
  "location": "LambdaTestSteps.loginValidCred()"
});
formatter.result({
  "duration": 23488830351,
  "status": "passed"
});
formatter.match({
  "location": "LambdaTestSteps.addProductsToCart()"
});
formatter.result({
  "duration": 40395585674,
  "status": "passed"
});
formatter.match({
  "location": "LambdaTestSteps.checkoutWithoutTOC()"
});
formatter.result({
  "duration": 20666764700,
  "status": "passed"
});
formatter.match({
  "location": "LambdaTestSteps.checkTOCWarning()"
});
formatter.result({
  "duration": 5040431967,
  "status": "passed"
});
formatter.match({
  "location": "LambdaTestSteps.checkoutWithTOC()"
});
formatter.result({
  "duration": 7465292073,
  "status": "passed"
});
formatter.match({
  "location": "LambdaTestSteps.checkPaymentModules()"
});
formatter.result({
  "duration": 1512649579,
  "status": "passed"
});
formatter.match({
  "location": "LambdaTestSteps.logoutFromSite()"
});
formatter.result({
  "duration": 7221050435,
  "status": "passed"
});
formatter.after({
  "duration": 22826,
  "status": "passed"
});
});