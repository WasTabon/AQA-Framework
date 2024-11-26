package com.ultimateqa.api;

import io.restassured.response.Response;

public class StatusAPI extends BaseAPIClient {

    public Response getStatus() {
        return requestSpec
                .when()
                .get("/status");
    }
}
