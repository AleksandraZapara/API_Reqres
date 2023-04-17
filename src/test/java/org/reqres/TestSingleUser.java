package org.reqres;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.reqres.mainReq.UsersHttpRequest;
import org.reqres.mainReq.dto.usersDto.Person;

import static org.reqres.TestData.*;

public class TestSingleUser {

    private UsersHttpRequest usersHttpRequest = new UsersHttpRequest();


    @Test
    public void testGetUser() {
        Response response = usersHttpRequest.getUsers(String.valueOf(id));
        Integer userId = response.then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getInt("data.id");
        Assertions.assertEquals(userId, 4);
    }

    @Test
    public void testAllUsers() {
        Response response = usersHttpRequest.getAllUsers();
        String userId = response.then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getString("data.id");
        Assertions.assertEquals(userId, "[7, 8, 9, 10, 11, 12]");
    }

    @Test
    public void testUpdateUser() {
        Response response = usersHttpRequest.getUsers(String.valueOf(id));
        Person person = new Person();
        person.setName(userName);
        person.setLastName(userLastName);
        Person p = usersHttpRequest.getUpdateUser(person, person.getId())
                .then().statusCode(200)
                .extract()
                .as(Person.class);
        Assertions.assertEquals(person.getName(), p.getName());
        Assertions.assertEquals(person.getLastName(), p.getLastName());
    }

    @Test
    public void testDeleteUser() {
        Response response = usersHttpRequest.getDeleteUser(String.valueOf(id));
        response.then().statusCode(204);
    }
}
