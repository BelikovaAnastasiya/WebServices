package com.epam.webservices.bonus_task.tests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class AuthenticationStep {

    private final String baseUrl = "https://api.github.com/gists";
    private final String token = "9a1575f6d42f5fc9351773667faacbdf1b5070ad";
    private final RequestSpecification requestSpecification = new RequestSpecBuilder().setBaseUri(baseUrl).build();

    RequestSpecification getGivenWithAuthentication() {
        return RestAssured.given().spec(requestSpecification).auth().oauth2(token);
    }
}
