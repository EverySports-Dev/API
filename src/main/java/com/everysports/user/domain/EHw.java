package com.everysports.user.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@EqualsAndHashCode
@Table(name = "eHw")
public class EHw {

    @Id
    @Column(name = "hw_ID")
    private Long hwID;

    @Column(name = "hw_Name")
    private String hwName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_ID")
    private EUser eUser;

}
