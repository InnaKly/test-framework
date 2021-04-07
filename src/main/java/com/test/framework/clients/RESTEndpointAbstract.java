package com.test.framework.clients;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import static com.test.framework.helpers.RestApiHelper.execRequest;
import static com.test.framework.utils.ConfigProvider.configuration;

@AllArgsConstructor
public class RESTEndpointAbstract {
    protected static final String BASE_URL = configuration().getStringProperty("BASE_URL");

    protected Response makeRequest(@NonNull Method request, RequestSpecification requestSpecification) {
        return execRequest(request, requestSpecification);
    }
}
