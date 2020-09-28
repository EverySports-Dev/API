package com.everysports.user.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@EqualsAndHashCode
@Table(name = "eHwAttach")
public class EHwAttach {

    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hwScore_ID")
    private EHwScore eHwScore;

    @Column(name = "fileName")
    private String fileName;

    @Column(name = "uploadPath")
    private String uploadPath;

}
