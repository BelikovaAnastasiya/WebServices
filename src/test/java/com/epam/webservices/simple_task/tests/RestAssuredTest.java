package com.epam.webservices.simple_task.tests;


import com.epam.webservices.simple_task.bean.User;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RestAssuredTest {

    @BeforeTest
    public void setUp()
    {
        RestAssured.baseURI = "http://jsonplaceholder.typicode.com";
    }

    @Test
    public void verifyHttpStatusCode()
    {
        Response response = RestAssured.given().get("/users").andReturn();
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void verifyHttpResponseHeader()
    {
        Response response = RestAssured.given().get("/users").andReturn();
        String typeOfContentTypeHeader = response.getHeader("content-type");
        if(typeOfContentTypeHeader.length()!=0) {
            Assert.assertTrue(typeOfContentTypeHeader.contains("application/json; charset=utf-8"));
        }
        else
        {
            Assert.assertNull(typeOfContentTypeHeader, "The content-type header doesn't exist in the obtained response");
        }
    }

    @Test
    public void verifyHttpResponseBody()
    {
        Response response = RestAssured.given().get("/users").andReturn();
        User[] users = response.as(User[].class);
        for(User user : users)
        {
            System.out.println(user);
        }
        Assert.assertEquals(users.length, 10);
    }





}
