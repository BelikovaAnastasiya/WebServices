package com.epam.webservices.bonus_task.tests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class AuthenticationStep {

    private final String token = "67b3d6c78187b4a8cb36eb8941fdcffe7680dc7d";
    private final String baseUrl = "https://api.github.com/gists";
    private final RequestSpecification requestSpecification = new RequestSpecBuilder().setBaseUri(baseUrl).build();

    RequestSpecification getGivenWithAuthentication() {
        return RestAssured.given().spec(requestSpecification).auth().oauth2(token);
    }
}
