package com.everysports.user.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.querydsl.core.annotations.QueryProjection;
import lombok.*;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@EqualsAndHashCode
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "class_ID")
@Table(name = "eClass")
public class EClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_ID")
    private Long classID;

//    @Column(name = "teacher_ID")
//    private Long teacherID;

    @Column(name = "class_Name")
    private String className;

    @Column(name = "class_Num")
    private Integer classNum;

    @Column(name = "class_Category")
    private Integer classCategory;

    @Column(name = "class_Curriculum")
    private String classCurriculum;

    @Column(name = "class_Policy")
    private String classPolicy;

    @Column(name = "class_LikeNum")
    private Integer classLikeNum;

    @Column(name = "class_Price")
    private Integer classPrice;

    @Column(name = "class_Lowerbound")
    private Integer classLowerbound;

    @Column(name = "class_OpenDate")
    @Temporal(TemporalType.DATE)
    private Date classOpenDate;

    @OneToOne
    @JoinColumn(name = "teacher_ID")
    private ETeacher eTeacher;

    @OneToMany(mappedBy = "eClass", fetch = FetchType.LAZY)
    private List<EClassAttach> eClassAttachList = new ArrayList<>();

}
