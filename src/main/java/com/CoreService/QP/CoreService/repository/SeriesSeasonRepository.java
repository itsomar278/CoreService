package com.CoreService.QP.CoreService.repository;

import com.CoreService.QP.CoreService.model.SeriesSeasonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeriesSeasonRepository extends JpaRepository<SeriesSeasonEntity , Integer> {
}
