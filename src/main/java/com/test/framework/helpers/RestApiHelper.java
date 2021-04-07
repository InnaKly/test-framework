package com.test.framework.helpers;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;

@Slf4j
public class RestApiHelper {
    public static Response execRequest(@NonNull Method request,
                                       @NonNull RequestSpecification requestSpecification) {
        requestSpecification.log().method().log().uri().log().headers().log().params().log().body();
        Response response = given().spec(requestSpecification).when().request(request);
        log.info(format("\nStatus code: %s\nResponse body:", response.statusCode()));
        response.getBody().prettyPrint();
        return response;
    }

    public static <T> T getDataFromResponseByPath(Response response, String path){
        return response.then().extract().path(path);
    }
}
