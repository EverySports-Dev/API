package com.everysports.user.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Table(name = "eTeacherSchedule")
public class ETeacherSchedule {

    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_ID")
    private ETeacher eTeacher;

    @Column(name = "day")
    private String day;

}
