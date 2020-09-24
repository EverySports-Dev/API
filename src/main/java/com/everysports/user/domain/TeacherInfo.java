package com.everysports.user.domain;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherInfo {

    private String teacherName;
    private String teacherEmail;
    private boolean teacherGender;
    private String teacherContent;
    private Long classSumNum;
    private String uploadPath;
    private String fileName;
    private List<ClassList> classList;
    private List<ReviewList> reviewList;

    @QueryProjection
    public TeacherInfo(String teacherName, String teacherEmail, boolean teacherGender, String teacherContent,Long classSumNum,
                       String uploadPath, String fileName){
        this.teacherName = teacherName;
        this.teacherEmail= teacherEmail;
        this.teacherGender = teacherGender;
        this.teacherContent = teacherContent;
        this.classSumNum = classSumNum;
        this.uploadPath = uploadPath;
        this.fileName = fileName;
    }

}
