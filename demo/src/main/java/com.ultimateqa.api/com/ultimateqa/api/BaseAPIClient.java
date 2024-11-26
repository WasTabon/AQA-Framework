package com.ultimateqa.api;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public abstract class BaseAPIClient {
    protected RequestSpecification requestSpec;

    public BaseAPIClient() {
        RestAssured.baseURI = "https://ultimateqa.com/api";
        requestSpec = RestAssured.given()
                .contentType("application/json")
                .accept("application/json");
    }
}
