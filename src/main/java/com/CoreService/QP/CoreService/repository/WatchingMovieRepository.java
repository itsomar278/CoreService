package com.CoreService.QP.CoreService.repository;

import com.CoreService.QP.CoreService.model.WatchingMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchingMovieRepository extends JpaRepository<WatchingMovie, Integer> {
}
