package com.everysports.user.domain.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class MyData {

    private Long hwID;
    private Date hwTime;
    private List<Score> hwScores;

    @QueryProjection
    public MyData(Long hwID, Date hwTime){
        this.hwID = hwID;
        this.hwTime = hwTime;
    }

}
