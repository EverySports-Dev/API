package com.everysports.user.repository.custom;

import com.everysports.user.domain.EHw;
import com.everysports.user.domain.QEHw;
import com.everysports.user.domain.QEHwScore;
import com.everysports.user.domain.dto.MyData;
import com.everysports.user.domain.dto.MyScore;
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
    public List<MyData> findByUserIDWithMyData(Long userID) {

        JPAQueryFactory query = new JPAQueryFactory(this.getEntityManager());
        QEHw eHw = QEHw.eHw;
        QEHwScore eHwScore = QEHwScore.eHwScore;
        List<MyData> result = query.select(Projections.constructor(MyData.class,eHwScore.eHw.hwID, eHwScore.hwTime)).from(eHwScore)
                            .where(eHwScore.eHw.eUser.userID.eq(userID)).fetch();

        result.forEach(r -> {
            if (r != null) {
                r.setHwScores(query.select(Projections.constructor(Score.class,eHwScore.eHw.hwName, eHwScore.great, eHwScore.normal, eHwScore.bad))
                        .from(eHwScore).where(eHwScore.eHw.eUser.userID.eq(userID)).fetch());
            }
        });

        return result;
    }

    @Override
    public List<MyScore> findByUserIDWithMyScore(Long userID) {

        JPAQueryFactory query = new JPAQueryFactory(this.getEntityManager());
        QEHw eHw = QEHw.eHw;
        QEHwScore eHwScore = QEHwScore.eHwScore;

        return query.select(Projections.constructor(MyScore.class))
                .from(eHw).join(eHwScore).on(eHwScore.eHw.eq(eHw)).limit(5).fetch();
    }
}
