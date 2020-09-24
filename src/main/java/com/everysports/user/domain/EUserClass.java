package com.everysports.user.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@EqualsAndHashCode
@Table(name = "eUserClass")
public class EUserClass {
    @Id
    @Column(name = "userClass_ID")
    private Long userClassID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_ID")
    private EClass eClass;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_ID")
    private EUser eUser;
}
