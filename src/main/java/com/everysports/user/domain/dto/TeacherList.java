package com.everysports.user.domain.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.Query;

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
    private boolean teacherGender;
    private String teacherContent;

    @QueryProjection
    public TeacherList(Long teacherID, String teacherName, String uploadPath, String fileName){
        this.teacherID = teacherID;
        this.teacherName = teacherName;
        this.uploadPath = uploadPath;
        this.fileName = fileName;
    }

    @QueryProjection
    public TeacherList(Long teacherID, String uploadPath, String fileName, String teacherName, boolean teacherGender, String teacherContent){
        this.teacherID = teacherID;
        this.uploadPath = uploadPath;
        this.fileName = fileName;
        this.teacherName = teacherName;
        this.teacherGender = teacherGender;
        this.teacherContent = teacherContent;
    }
}
