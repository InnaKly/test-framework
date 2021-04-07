package com.test.framework.clients;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserRestEndpoint extends RESTEndpointAbstract {

    private static final String GET_USER_URL = BASE_URL + "/public-api/users/%s";
    private static final String GET_ALL_USERS_URL = BASE_URL + "/public-api/users";
    private static final String CREATE_USER_URL = BASE_URL + "/public-api/users";

    public Response getUserById(Integer id) {
        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri(String.format(GET_USER_URL, id))
                .build();
        return makeRequest(Method.GET, requestSpecification);
    }

    public Response getAllUsers() {
        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri(GET_ALL_USERS_URL)
                .build();
        return makeRequest(Method.GET, requestSpecification);
    }
}
