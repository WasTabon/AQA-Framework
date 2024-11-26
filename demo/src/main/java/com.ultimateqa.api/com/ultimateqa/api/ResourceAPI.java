package com.ultimateqa.api;

import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;

public class ResourceAPI extends BaseAPIClient {

    public Response createResource(String name, String type) {
        Map<String, String> resourceData = new HashMap<>();
        resourceData.put("name", name);
        resourceData.put("type", type);

        return requestSpec
                .body(resourceData)
                .when()
                .post("/resources");
    }

    public Response createInvalidResource() {
        Map<String, String> resourceData = new HashMap<>();

        return requestSpec
                .body(resourceData)
                .when()
                .post("/resources");
    }
}
