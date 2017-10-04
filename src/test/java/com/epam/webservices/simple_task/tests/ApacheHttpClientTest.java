package com.epam.webservices.simple_task.tests;

import com.epam.webservices.simple_task.bean.User;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ApacheHttpClientTest {

    @Test (description = "Check status code")
    public void verifyHttpStatusCode() throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://jsonplaceholder.typicode.com/users");
        CloseableHttpResponse response = httpclient.execute(httpGet);
        try {
            int statusCode = response.getStatusLine().getStatusCode();
            Assert.assertEquals(statusCode, 200);
        }
        finally {
            response.close();
        }
    }

    @Test(description = "Check http response header")
    public void verifyHttpResponseHeader() throws IOException {
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet("http://jsonplaceholder.typicode.com/users");
            CloseableHttpResponse response = httpclient.execute(httpGet);
            try {
                String headerContentType = response.getLastHeader("content-type").getValue();
                if(headerContentType.length()!=0) {
                    Assert.assertTrue(headerContentType.contains("application/json; charset=utf-8"));
                }
                else
                {
                    Assert.assertNull(headerContentType, "The content-type header doesn't exist in the obtained response");
                }
            }
            finally {
                response.close();
            }
    }

    @Test(description = "Check http response body")
    public void verifyHttpResponseBody() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://jsonplaceholder.typicode.com/users");
        CloseableHttpResponse response = httpClient.execute(httpGet);

        try{
           HttpEntity httpEntity = response.getEntity();
            if(httpEntity != null )
            {
                Gson gson = new Gson();
                User[] users = gson.fromJson(EntityUtils.toString(httpEntity), User[].class);
                for(User user : users)
                {
                    System.out.println(user);
                }
                Assert.assertEquals(users.length, 10);
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
