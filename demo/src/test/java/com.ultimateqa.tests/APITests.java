package com.ultimateqa.tests;

import com.ultimateqa.api.AuthAPI;
import com.ultimateqa.api.ResourceAPI;
import com.ultimateqa.api.StatusAPI;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APITests extends BaseAPITest {

    @Test(description = "Verify API response for valid endpoint", groups = {"api"})
    public void verifyValidEndpoint() {
        StatusAPI statusAPI = new StatusAPI();
        Response response = statusAPI.getStatus();

        Assert.assertEquals(response.getStatusCode(), 200, "Status code mismatch!");
        Assert.assertTrue(response.getBody().asString().contains("status"), "Response body missing 'status'!");
    }

    @Test(description = "Verify API authentication", groups = {"api"})
    public void verifyAuthentication() {
        AuthAPI authAPI = new AuthAPI();
        Response response = authAPI.login("testUser", "testPassword");

        Assert.assertEquals(response.getStatusCode(), 200, "Authentication failed!");
        Assert.assertTrue(response.jsonPath().getString("token") != null, "Token is missing in response!");
    }

    @Test(description = "Verify API response for invalid data", groups = {"api"})
    public void verifyInvalidDataHandling() {
        ResourceAPI resourceAPI = new ResourceAPI();
        Response response = resourceAPI.createInvalidResource();

        Assert.assertEquals(response.getStatusCode(), 400, "Expected 400 Bad Request!");
        Assert.assertTrue(response.getBody().asString().contains("error"), "Error message is missing!");
    }
}
