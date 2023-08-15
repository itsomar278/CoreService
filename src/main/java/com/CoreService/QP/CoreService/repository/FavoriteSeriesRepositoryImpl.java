package com.CoreService.QP.CoreService.repository;

import com.CoreService.QP.CoreService.model.FavoriteSeriesEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class FavoriteSeriesRepositoryImpl {
    @PersistenceContext
    private EntityManager entityManager;
    @Lazy
    @Autowired
    private FavoriteSeriesRepository favoriteSeriesRepository;

    FavoriteSeriesEntity findByUserIdAndSeriesId(int userId, int seriesId)
    {
        String hql = "SELECT fs FROM FavoriteSeriesEntity fs WHERE fs.userId = :userId AND fs.series.id = :seriesId";
        TypedQuery<FavoriteSeriesEntity> query = entityManager.createQuery(hql, FavoriteSeriesEntity.class);
        query.setParameter("userId", userId);
        query.setParameter("seriesId", seriesId);
        return query.getSingleResult();
    }

}
