package com.test.framework.crud;

import com.test.framework.clients.UserRestEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.test.framework.helpers.RestApiHelper.getDataFromResponseByPath;

@Slf4j
public class UserEndpointTest {

    private final UserRestEndpoint userRestEndpoint = new UserRestEndpoint();

    @Test
    public void getUserDataTest(){
        Integer expectedUserId = 7;
        Integer actualUserId = getDataFromResponseByPath(userRestEndpoint.getUserById(expectedUserId), "data.id");
        log.info("Actual user id is: " + actualUserId);
        Assertions.assertEquals(expectedUserId, actualUserId);
    }

    @Test
    public void checkErrorCodeWithInvalidUserId(){
        int actualStatusCode = getDataFromResponseByPath(userRestEndpoint.getUserById(0), "code");
        log.info("Actual status code is: " + actualStatusCode);
        Assertions.assertEquals(HttpStatus.SC_NOT_FOUND, actualStatusCode);
    }
}
