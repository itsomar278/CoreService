package com.CoreService.QP.CoreService.repository;

import com.CoreService.QP.CoreService.model.SeriesSeason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeriesSeasonRepository extends JpaRepository<SeriesSeason, Integer> {
}
