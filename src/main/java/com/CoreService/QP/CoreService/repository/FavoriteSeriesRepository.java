package com.CoreService.QP.CoreService.repository;

import com.CoreService.QP.CoreService.controller.response.MostFavoriteSeries;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.CoreService.QP.CoreService.model.FavoriteSeries;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavoriteSeriesRepository extends PagingAndSortingRepository<FavoriteSeries, Integer>, JpaRepository<FavoriteSeries, Integer> {

    @Query("SELECT fs FROM FavoriteSeries fs WHERE fs.userId = ?1 AND fs.series.id = ?2 AND fs.isDeleted = false")
    Optional<FavoriteSeries> findByUserIdAndSeriesId(int userId, int seriesId);

    @Query("SELECT fs FROM FavoriteSeries fs WHERE fs.userId = ?1 AND fs.isDeleted = false")
    List<FavoriteSeries> findByUserId(int userId, Pageable pageable);

    @Modifying
    @Query("UPDATE FavoriteSeries fs SET fs.isDeleted = true WHERE fs.id = ?1")
    @Override
    void deleteById(Integer integer);

    @Query("SELECT COUNT(fs) FROM FavoriteSeries fs WHERE fs.isDeleted = false AND fs.userId = ?1")
    int countByUserId(int userId);

    @Query("SELECT NEW com.CoreService.QP.CoreService.controller.response.MostFavoriteSeries(" +
            "COUNT(fs.id), " +
            "s) " +
            "FROM FavoriteSeries fs " +
            "JOIN fs.series s " +
            "WHERE fs.isDeleted = false " +
            "GROUP BY s.id " +
            "ORDER BY COUNT(fs.id) DESC")
    Page<MostFavoriteSeries> findMostFavoriteSeries(Pageable pageable);
}
