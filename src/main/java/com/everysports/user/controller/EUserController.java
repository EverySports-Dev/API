package com.everysports.user.controller;

import com.everysports.user.domain.EUser;
import com.everysports.user.domain.dto.*;
import com.everysports.user.service.EUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EUserController {

    @Autowired
    private EUserService eUserService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody EUser resource){
        EUser eUser = eUserService.addEUser(resource);
        return eUser == resource
                ? new ResponseEntity<>("success", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("euser/{user_ID}")
    public EUser getEUser(@PathVariable("user_ID")Long user_ID){
        return eUserService.getEUser(user_ID);
    }

    @GetMapping("/payment/{classID}&{teacherID}&{userID}")
    public ScheduleList getPayment(@PathVariable("classID")Long classID, @PathVariable("teacherID")Long teacherID, @PathVariable("userID")Long userID){
        return eUserService.getPayment(classID, teacherID, userID);
    }

    @PostMapping("/payment/detail")
    public ResponseEntity<String> postPayment(@RequestBody PaymentList paymentList){

        return eUserService.postPayment(paymentList) == 1
                ? new ResponseEntity<>("success", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/sports/schedule/{userID}")
    public List<UserScheduleList> getSports(@PathVariable("userID") Long userID){
        return eUserService.getSports(userID);
    }

    @GetMapping("/mydata/{userID}")
    public List<MyData> getMyData(@PathVariable("userID")Long userID){
        return eUserService.getMydata(userID);
    }

    @GetMapping("/mydata/score/{userID}")
    public List<MyScore> getMyScore(@PathVariable("userID") Long userID){
        return eUserService.getMyScore(userID);
    }
}
