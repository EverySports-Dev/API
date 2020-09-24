package com.everysports.user.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassList {

     private Long classID;
     private String className;
     private String teacherName;
     private Integer classPrice;
     private String uploadPath;
     private String fileName;
     private Integer classNum;
     private Date classOpenDate;
     private String classPolicy;
     private String classCurriculum;

     @QueryProjection
     public ClassList(Long classID, String className, String teacherName, Integer classPrice, String uploadPath, String fileName, Integer classNum, Date classOpenDate){
          this.classID = classID;
          this.className = className;
          this.teacherName = teacherName;
          this.classPrice = classPrice;
          this.uploadPath = uploadPath;
          this.fileName = fileName;
          this.classNum = classNum;
          this.classOpenDate = classOpenDate;
     }

     @QueryProjection
     public ClassList(Long classID, String className, Integer classNum, Integer classPrice, String uploadPath, String fileName, String classPolicy, String classCurriculum){
          this.classID = classID;
          this.className = className;
          this.classNum = classNum;
          this.classPrice = classPrice;
          this.uploadPath = uploadPath;
          this.fileName = fileName;
          this.classPolicy = classPolicy;
          this.classCurriculum = classCurriculum;
     }


}
