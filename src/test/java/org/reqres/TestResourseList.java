package org.reqres;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.reqres.mainReq.ResourseHttpRequest;

public class TestResourseList {

    private ResourseHttpRequest resourseHttpRequest = new ResourseHttpRequest();

    @Test
    public void testSingleList() {
        Response response = resourseHttpRequest.getSingleList("3");
        String listName = response.then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getString("data.name");
        Assertions.assertEquals(listName, "true red");
    }

    @Test
    public void testAllListYear() {
        Response response = resourseHttpRequest.getAllList();
        String listYear = response.then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getString("data.year");
        Assertions.assertEquals(listYear, "[2000, 2001, 2002, 2003, 2004, 2005]");
    }
}
