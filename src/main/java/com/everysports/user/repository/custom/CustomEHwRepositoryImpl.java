package com.everysports.user.repository.custom;

import com.everysports.user.domain.EHw;
import com.everysports.user.domain.QEHw;
import com.everysports.user.domain.QEHwScore;
import com.everysports.user.domain.dto.MyData;
import com.everysports.user.domain.dto.Score;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class CustomEHwRepositoryImpl extends QuerydslRepositorySupport implements CustomEHwRepository {

    public CustomEHwRepositoryImpl() {
        super(EHw.class);
    }

    @Override
    public MyData findByUserIDWithMyData(Long userID) {

        JPAQueryFactory query = new JPAQueryFactory(this.getEntityManager());
        QEHw eHw = QEHw.eHw;
        QEHwScore eHwScore = QEHwScore.eHwScore;
        MyData result = query.select(Projections.constructor(MyData.class,eHwScore.eHw.hwID, eHwScore.hwTime)).from(eHwScore)
                            .where(eHwScore.eHw.eUser.userID.eq(userID)).fetchOne();

        if (result != null) {
            result.setHwScores(query.select(Projections.constructor(Score.class,eHwScore.eHw.hwName, eHwScore.great, eHwScore.normal, eHwScore.bad))
                                .from(eHwScore).where(eHwScore.eHw.eUser.userID.eq(userID)).fetch());
        }


        return result;
    }
}
