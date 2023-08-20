package com.CoreService.QP.CoreService.repository;

import com.CoreService.QP.CoreService.controller.response.MostWatchedMovie;
import com.CoreService.QP.CoreService.controller.response.TrendingMovie;
import com.CoreService.QP.CoreService.model.WatchingMovie;
import jakarta.persistence.Tuple;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface WatchingMovieRepository extends JpaRepository<WatchingMovie, Integer> {
    @Query("SELECT NEW com.CoreService.QP.CoreService.controller.response.MostWatchedMovie(" +
            "wm.movie, " +
            "COUNT(wm.id)) " +
            "FROM WatchingMovie wm " +
            "JOIN MovieCategory mc ON wm.movie.id = mc.movie.id " +
            "WHERE wm.isDeleted = false " +
            "GROUP BY wm.movie " +
            "ORDER BY COUNT(wm.id) DESC")
    Page<MostWatchedMovie> findMostWatched(Pageable pageable);


    @Query("SELECT NEW com.CoreService.QP.CoreService.controller.response.TrendingMovie(" +
            "wm.movie, " +
            "COUNT(wm.id)) " +
            "FROM WatchingMovie wm " +
            "JOIN MovieCategory mc ON wm.movie.id = mc.movie.id " +
            "WHERE wm.isDeleted = false " +
            "AND wm.startingDate >= :lastWeekStartDate " +
            "GROUP BY wm.movie " +
            "ORDER BY COUNT(wm.id) DESC")
    Page<TrendingMovie> findTrendingMovie(Pageable pageable, @Param("lastWeekStartDate") Date lastWeekStartDate);
}
