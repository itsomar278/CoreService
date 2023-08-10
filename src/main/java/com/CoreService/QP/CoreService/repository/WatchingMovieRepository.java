package com.CoreService.QP.CoreService.repository;

import com.CoreService.QP.CoreService.model.WatchingMovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchingMovieRepository extends JpaRepository<WatchingMovieEntity, Integer> {
}
