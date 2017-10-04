package com.epam.webservices.bonus_task.tests;

import com.epam.webservices.bonus_task.bean.GitHubUser;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetUserHttpClientTest {

    @BeforeTest
    public void setUp()
    {
        RestAssured.baseURI = "https://api.github.com/users";
    }

    @Test
    public void gitHubCheckStatusCodeTest() throws IOException {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://api.github.com/users/BelikovaAnastasiya");
        CloseableHttpResponse response = httpclient.execute(httpGet);
        try {
            int statusCode = response.getStatusLine().getStatusCode();
            System.out.println(statusCode);
            Assert.assertEquals(statusCode, 200);
        }
        finally {
            response.close();
        }
    }

    @Test
    public void gitHubResponseBodyTest() throws IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://api.github.com/users/BelikovaAnastasiya");
        CloseableHttpResponse response = httpClient.execute(httpGet);

        try{
            HttpEntity httpEntity = response.getEntity();
            if(httpEntity != null )
            {
                Gson gson = new Gson();
                GitHubUser users = gson.fromJson(EntityUtils.toString(httpEntity), GitHubUser.class);
                System.out.println(users);
            }
            else
            {
                Assert.assertNull(httpEntity, "The content of response body is null");
            }
        }
        finally {
            response.close();
        }
    }
}
