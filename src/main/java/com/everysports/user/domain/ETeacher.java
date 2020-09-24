package com.everysports.user.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@EqualsAndHashCode
@Table(name = "eTeacher")
public class ETeacher {

    @Id
    @Column(name = "teacher_ID")
    private Long teacherID;

    @MapsId("allID")
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "all_ID")
    private EAll eAll;

    @Column(name = "teacher_Email")
    private String teacherEmail;

    @Column(name = "teacher_Name")
    private String teacherName;

    @Column(name = "teacher_Gender")
    private boolean teacherGender;

    @Column(name = "teacher_Birthday")
    private Date teacherBirthday;

    @Column(name = "teacher_Phone")
    private String teacherPhone;

    @Column(name = "teacher_Content")
    private String teacherContent;

    @Column(name = "teacher_Point")
    private Integer teacherPoint;
}
