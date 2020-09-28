package com.everysports.user.domain.dto;

import lombok.Data;

import java.util.List;

@Data
public class ScheduleList {

    private String teacherSchedule;
    private String mySchedule;
    private List<String> userSchedule;

}
