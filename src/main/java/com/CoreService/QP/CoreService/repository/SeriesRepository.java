package com.CoreService.QP.CoreService.repository;

import com.CoreService.QP.CoreService.model.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SeriesRepository extends JpaRepository<Series,Integer> {
    @Query("SELECT s FROM Series s WHERE s.id = ?1 AND s.isDeleted = false")
    @Override
    Optional<Series> findById(Integer id);}


