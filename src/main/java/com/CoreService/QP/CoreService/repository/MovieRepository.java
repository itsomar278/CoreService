package com.CoreService.QP.CoreService.repository;

import com.CoreService.QP.CoreService.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {

    @Query("SELECT m FROM Movie m WHERE m.id = ?1 AND m.isDeleted = false")
    @Override
    Optional<Movie> findById(Integer id);
}
