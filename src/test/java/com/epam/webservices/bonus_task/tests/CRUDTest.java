package com.epam.webservices.bonus_task.tests;

import com.epam.webservices.bonus_task.bean.File;
import com.epam.webservices.bonus_task.bean.Gist;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CRUDTest extends AuthenticationStep {

    private String workingGist;

    private Gist newGist() {
        Gist gist = new Gist();
        gist.setDescription("The description for this gist");
        gist.setPublic(true);
        gist.setFile("file1.txt", new File("String file content"));
        gist.setComments(666);
        return gist;
    }

    @Test( description = "Create new gist")
    public void createGistTest()
    {
        Response response  = getGivenWithAuthentication().
                body(newGist()).
                with().contentType("application/json").post().andReturn();
        Assert.assertEquals(response.statusCode(), 201);
        workingGist = response.as(Gist.class).getId();
    }

    @Test(dependsOnMethods = "createGistTest", description = "Get gist")
    public void getGistTest() {
        Response response = getGivenWithAuthentication().get("/" + workingGist).andReturn();
        Gist getGist = response.as(Gist.class);
        System.out.println(getGist);
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(dependsOnMethods = "getGistTest", description = "Change count comments in the gist")
    public void updateCountCommentsInTheGistTest() {
        Gist gist = newGist();
        int oldCountComments = gist.getComments();
        int newCountComments = 1000;
        int finalCountComments;
        gist.setComments(newCountComments);
        Response response = getGivenWithAuthentication().
                body(gist).
                with().contentType("application/json").patch("/" + workingGist).andReturn();
        finalCountComments = response.as(Gist.class).getComments();
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertNotEquals(finalCountComments, oldCountComments);
    }

    @Test (dependsOnMethods = "updateCountCommentsInTheGistTest", description = "Star a gist")
    public void  starGistTest()
    {
        Response response = getGivenWithAuthentication().put("/" + workingGist + "/star" ).andReturn();
        Assert.assertEquals(response.statusCode(), 204);
    }

    @Test(dependsOnMethods = "starGistTest", description = "Delete gist")
    public void deleteGistTest() {
        Response response = getGivenWithAuthentication().delete("/" + workingGist).andReturn();
        Assert.assertEquals(response.statusCode(), 204);
    }
}
