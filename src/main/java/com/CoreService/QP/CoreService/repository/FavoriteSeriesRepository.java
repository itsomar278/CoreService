package com.CoreService.QP.CoreService.repository;

import com.CoreService.QP.CoreService.model.FavoriteSeries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteSeriesRepository extends JpaRepository<FavoriteSeries, Integer>{
    @Query(value = "SELECT * FROM core.favorite_series WHERE user_id = ?1 AND series_id = ?2", nativeQuery = true)
    FavoriteSeries findByUserIdAndSeriesId(int userId, int seriesId);

    @Query(value = "SELECT * FROM core.favorite_series WHERE user_id = ?1", nativeQuery = true)
    List<FavoriteSeries> findByUserId(int userId);
}
