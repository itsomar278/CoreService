package com.CoreService.QP.CoreService.repository;

import com.CoreService.QP.CoreService.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {
    @Query(value = "SELECT * FROM core.movie WHERE id = ?1 AND is_deleted = false", nativeQuery = true)
    @Override
    Optional<Movie> findById(Integer id);
}
