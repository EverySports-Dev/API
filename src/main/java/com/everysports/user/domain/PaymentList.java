package com.everysports.user.domain;

import lombok.Data;

import java.util.Date;

@Data
public class PaymentList {
    private Long teacherID;
    private Long classID;
    private Long userID;
    private Long classPrice;
    private String userSchedule;
    private Date startTime;
    private Date endTime;
}
