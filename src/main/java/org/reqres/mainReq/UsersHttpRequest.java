package org.reqres.mainReq;

import io.restassured.response.Response;
import org.reqres.mainReq.dto.usersDto.Person;

public class UsersHttpRequest extends BaseHttpRequest {
    private static final String userUrl = "api/users";

    public Response getAllUsers() {
        return getRequestSpecification()
                .when()
                .param("page",2)
                .get(userUrl);
    }

    public Response getUsers(String id) {
        return getRequestSpecification()
                .when()
                .get(userUrl +"/"+ id);
    }

    public Response getUpdateUser(Person person, String id) {
        return getRequestSpecification()
                .when()
                .body(person)
                .put(userUrl +"/"+ id);
    }

    public Response getDeleteUser(String id) {
        return getRequestSpecification()
                .when()
                .delete(userUrl +"/" + id);
    }
}
