package com.CoreService.QP.CoreService.repository;

import com.CoreService.QP.CoreService.model.MovieSeasonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieSeasonRepository extends JpaRepository<MovieSeasonEntity, Integer> {
}
