package com.epam.webservices.bonus_task.tests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class AuthenticationStep {

    private final String token = "48bcac7a80cda2daec6fb01825c58f69f7913b60";
    private final String baseUrl = "https://api.github.com/gists";
    private final RequestSpecification requestSpecification = new RequestSpecBuilder().setBaseUri(baseUrl).build();

    RequestSpecification getGivenWithAuthentication() {
        return RestAssured.given().spec(requestSpecification).auth().oauth2(token);
    }
}
