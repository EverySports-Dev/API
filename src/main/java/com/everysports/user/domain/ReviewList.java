package com.everysports.user.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewList {

    private Long userID;
    private String reviewTitle;
    private String reviewContent;
    private Date reviewCreatedAt;

}
