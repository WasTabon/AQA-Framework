package com.ultimateqa.api;

import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;

public class AuthAPI extends BaseAPIClient {

    public Response login(String username, String password) {
        Map<String, String> credentials = new HashMap<>();
        credentials.put("username", username);
        credentials.put("password", password);

        return requestSpec
                .body(credentials)
                .when()
                .post("/auth/login");
    }
}
