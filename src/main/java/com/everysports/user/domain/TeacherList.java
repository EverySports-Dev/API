package com.everysports.user.domain;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherList {

    private Long teacherID;
    private String teacherName;
    private Long classSumNum;
    private String uploadPath;
    private String fileName;

    @QueryProjection
    public TeacherList(Long teacherID, String teacherName, String uploadPath, String fileName){
        this.teacherID = teacherID;
        this.teacherName = teacherName;
        this.uploadPath = uploadPath;
        this.fileName = fileName;
    }
}
