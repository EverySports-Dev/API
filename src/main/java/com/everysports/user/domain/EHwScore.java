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
@Table(name = "eHwScore")
public class EHwScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hwScore_ID")
    private Long hwScoreID;

    @Column(name = "hw_Time")
    private Date hwTime;

    @Column(name = "great")
    private Integer great;

    @Column(name = "normal")
    private Integer normal;

    @Column(name = "bad")
    private Integer bad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hw_ID")
    private EHw eHw;

}
