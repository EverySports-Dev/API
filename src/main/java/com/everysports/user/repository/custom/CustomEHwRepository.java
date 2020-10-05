package com.everysports.user.repository.custom;

import com.everysports.user.domain.dto.MyData;
import com.everysports.user.domain.dto.MyScore;

import java.util.List;

public interface CustomEHwRepository {

    List<MyData> findByUserIDWithMyData(Long userID);

    List<MyScore> findByUserIDWithMyScore(Long userID);
}
