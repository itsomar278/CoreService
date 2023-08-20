package com.CoreService.QP.CoreService.repository;

import com.CoreService.QP.CoreService.controller.response.MostWatchedSeries;
import com.CoreService.QP.CoreService.controller.response.TrendingSeries;
import com.CoreService.QP.CoreService.model.WatchingEpisode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface WatchingEpisodeRepository extends JpaRepository<WatchingEpisode, Integer> {

    @Query("SELECT NEW com.CoreService.QP.CoreService.controller.response.MostWatchedSeries(" +
            "we.series, " +
            "COUNT(we.id)) " +
            "FROM WatchingEpisode we " +
            "WHERE we.isDeleted = false " +
            "GROUP BY we.series " +
            "ORDER BY COUNT(we.id) DESC")
    Page<MostWatchedSeries> findMostWatchedSeries(Pageable pageable);

    @Query("SELECT NEW com.CoreService.QP.CoreService.controller.response.TrendingSeries(" +
            "we.series, " +
            "COUNT(we.id)) " +
            "FROM WatchingEpisode we " +
            "WHERE we.isDeleted = false " +
            "AND we.startingDate >= :lastWeekStartDate " +
            "GROUP BY we.series " +
            "ORDER BY COUNT(we.id) DESC")
    Page<TrendingSeries> findTrendingSeries(
            Pageable pageable,
            @Param("lastWeekStartDate") Date lastWeekStartDate
    );
}
