package com.everysports.user.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassInfo {

    private ClassList classList;
    private TeacherList teacherList;
    private List<ReviewList> reviewList;

}
