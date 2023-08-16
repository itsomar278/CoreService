package com.CoreService.QP.CoreService.repository;

import com.CoreService.QP.CoreService.model.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SeriesRepository extends JpaRepository<Series,Integer> {
    @Query(value = "SELECT * FROM core.series WHERE id = ? AND is_deleted = false", nativeQuery = true)
    @Override
    Optional<Series> findById(Integer id);
}
