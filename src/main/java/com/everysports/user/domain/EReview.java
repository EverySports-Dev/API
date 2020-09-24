package com.everysports.user.domain;

import com.everysports.user.controller.EUserController;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@EqualsAndHashCode
@Table(name = "eReview")
public class EReview {

    @Id
    @Column(name = "review_ID")
    private Long reviewID;

    @Column(name = "review_Title")
    private String reviewTitle;

    @Column(name = "review_Content")
    private String reviewContent;

    @Column(name = "review_CreatedAt")
    private Date reviewCreatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userClass_ID")
    private EUserClass eUserClass;

}
