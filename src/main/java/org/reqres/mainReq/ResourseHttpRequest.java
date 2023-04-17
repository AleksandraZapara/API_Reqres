package org.reqres.mainReq;

import io.restassured.response.Response;

public class ResourseHttpRequest extends BaseHttpRequest{

    private static final String resourseUrl = "api/unknown";

    public Response getSingleList(String id) {
        return getRequestSpecification()
                .when()
                .get(resourseUrl + "/"+ id);
    }

    public Response getAllList() {
        return getRequestSpecification()
                .when()
                .get(resourseUrl);
    }
}
