package org.reqres.mainReq.dto.resourseDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Resourse {

    private Integer page;
    private Integer total;
}
