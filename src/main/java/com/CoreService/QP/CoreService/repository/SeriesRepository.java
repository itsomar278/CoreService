package com.CoreService.QP.CoreService.repository;

import com.CoreService.QP.CoreService.model.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeriesRepository extends JpaRepository<Series,Integer> {
}
