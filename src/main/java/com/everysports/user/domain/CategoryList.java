package com.everysports.user.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryList {

    private Long classID;
    private String className;
    private Integer classNum;
    private Integer classPrice;
    private boolean teacherGender;
    private String uploadPath;
    private String fileName;

}
