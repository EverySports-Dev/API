package com.everysports.user.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassList {

     private String className;

     private String teacherName;

     private Integer classPrice;

     private String uploadPath;

     private String fileName;

     private Integer classNum;

     private Date classOpenDate;

}
