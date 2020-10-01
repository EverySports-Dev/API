package com.everysports.user.domain.dto;

import lombok.Data;

import java.util.Date;

@Data
public class Payment {

    private Long teacherID;
    private Long userID;
    private Long classID;
    private Integer classPrice;
    private String userSchedule;
    private Date startTime;
    private Date endTime;

}
