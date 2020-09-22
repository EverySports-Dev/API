package com.everysports.user.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@EqualsAndHashCode
public class ClassList {

    @Column(name="class_Name")
    private String className;

    @Column(name="teacher_Name")
    private String teacherName;

    @Column(name="class_Price")
    private Integer classPrice;

    @Column(name="uploadPath")
    private String uploadPath;

    @Column(name="fileName")
    private String fileName;

    @Column(name="class_Num")
    private Integer classNum;

}
