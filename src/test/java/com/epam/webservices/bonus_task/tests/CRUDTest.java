package com.epam.webservices.bonus_task.tests;

import com.epam.webservices.bonus_task.bean.Gist;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CRUDTest extends AuthenticationStep {

    private String workingGist;
    private String id = "ffb3630313f105e57645f9c647d233f6";
    private String id2 = "26afcc73fbea784794518c1e82b39f87";

    @Test( description = "Create new gist")
    public void createGistTest()
    {
        Gist newGist = new Gist("new Gist");
        Response response  = getGivenWithAuthentication().
                body(newGist).
                with().contentType("application/json").post().andReturn();
        Assert.assertEquals(response.statusCode(), 201);
        workingGist = response.as(Gist.class).getId();
    }

    @Test(description = "Get gist")
    public void getGistTest() {
        Response response = getGivenWithAuthentication().get("/" + id2).andReturn();
        Gist getGist = response.as(Gist.class);
        System.out.println(getGist);
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(description = "Change count comments in the gist")
    public void updateCountCommentsInTheGistTest() {
        Gist gist = new Gist("new Gist");
        int oldCountComments = gist.getComments();
        int newCountComments = 1000;
        int finalCountComments;
        gist.setComments(newCountComments);
        Response response = getGivenWithAuthentication().body(gist).with().contentType("application/json").patch("/" + id2).andReturn();
        finalCountComments = response.as(Gist.class).getComments();
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertNotEquals(finalCountComments, oldCountComments);
    }

    @Test(description = "Delete gist")
    public void deleteGistTest() {
        Response response = getGivenWithAuthentication().delete("/" + workingGist).andReturn();
        Assert.assertEquals(response.statusCode(), 204);
    }

    @Test (description = "Star a gist")
    public void  starGistTest()
    {
        Response response = getGivenWithAuthentication().put("/" + workingGist + "/star" ).andReturn();
        Assert.assertEquals(response.statusCode(), 204);
    }



}
