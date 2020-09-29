package com.everysports.user.repository.custom;

import com.everysports.user.domain.dto.MyData;

import java.util.List;

public interface CustomEHwRepository {

    MyData findByUserIDWithMyData(Long userID);

}
