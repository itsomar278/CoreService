package com.CoreService.QP.CoreService.repository;

import com.CoreService.QP.CoreService.model.FavoriteSeries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavoriteSeriesRepository extends JpaRepository<FavoriteSeries, Integer>{
    @Query(value = "SELECT * FROM core.favorite_series WHERE user_id = ?1 AND series_id = ?2 AND is_deleted = false", nativeQuery = true)
    Optional<FavoriteSeries> findByUserIdAndSeriesId(int userId, int seriesId);

    @Query(value = "SELECT * FROM core.favorite_series WHERE user_id = ?1 AND is_deleted = false LIMIT ?3 OFFSET ?2 * ?3", nativeQuery = true)
    Optional<List<FavoriteSeries>> findByUserId(int userId , int page , int size);

    @Modifying
    @Query(value = "UPDATE core.favorite_series SET is_deleted = true WHERE id = ?1", nativeQuery = true)
    @Override
    void deleteById(Integer id);
}
