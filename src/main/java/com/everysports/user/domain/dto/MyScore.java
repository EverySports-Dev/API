package com.everysports.user.domain.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import org.springframework.data.jpa.repository.Query;

@Data
public class MyScore {

    private String hwName;
    private Integer great;
    private Integer normal;
    private Integer bad;

}
