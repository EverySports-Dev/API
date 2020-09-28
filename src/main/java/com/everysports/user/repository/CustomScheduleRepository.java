package com.everysports.user.repository;

import com.everysports.user.domain.ScheduleList;
import com.everysports.user.domain.UserScheduleList;

import java.util.List;

public interface CustomScheduleRepository {
    String findByClassIDAndUserID(Long classID, Long userID);
    List<String> findByClassID(Long classID);
    String findByTeacherID(Long teacherID);
    List<UserScheduleList> findByUserIDWithUserScheduleList(Long userID);
}
