package com.everysports.user.service;

import com.everysports.user.domain.EAll;
import com.everysports.user.domain.EUser;
import com.everysports.user.domain.ScheduleList;
import com.everysports.user.repository.EAllRepository;
import com.everysports.user.repository.EUserRepository;
import com.everysports.user.repository.ScheduleRepository;
import javafx.scene.canvas.GraphicsContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EUserService {

    @Autowired
    private EUserRepository eUserRepository;

    @Autowired
    private EAllRepository eAllRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    public EUser addEUser(EUser eUser) {
        eAllRepository.save(new EAll(eUser.getUserID(), 1));
        eUser.setUserPoint(0);
        return eUserRepository.save(eUser);
    }

    public EUser getEUser(Long user_ID){
        return eUserRepository.findByUserID(user_ID);
    }

    public ScheduleList getPayment(Long classID, Long teacherID, Long userID){
        ScheduleList scheduleList = new ScheduleList();
        scheduleList.setMySchedule(scheduleRepository.findByClassIDAndUserID(classID, userID));
        scheduleList.setTeacherSchedule(scheduleRepository.findByTeacherID(teacherID));
        scheduleList.setUserSchedule(scheduleRepository.findByClassID(classID));

        return scheduleList;
    }
}
