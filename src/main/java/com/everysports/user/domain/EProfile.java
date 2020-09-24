package com.everysports.user.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@EqualsAndHashCode
@Table(name = "eProfile")
public class EProfile {

    @Id
    @Column(name="all_ID")
    private Long allID;

    @MapsId("allID")
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "all_ID")
    private EAll eAll;

    @Column(name = "uploadPath")
    private String uploadPath;

    @Column(name = "fileName")
    private String fileName;

}
