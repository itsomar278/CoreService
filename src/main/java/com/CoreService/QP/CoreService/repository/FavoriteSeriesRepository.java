package com.CoreService.QP.CoreService.repository;

import com.CoreService.QP.CoreService.model.FavoriteSeriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteSeriesRepository extends JpaRepository<FavoriteSeriesEntity, Integer>{
    FavoriteSeriesEntity findByUserIdAndSeriesId(int userId, int seriesId);
}
