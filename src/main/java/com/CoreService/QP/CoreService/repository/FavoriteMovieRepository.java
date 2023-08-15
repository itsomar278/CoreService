package com.CoreService.QP.CoreService.repository;

import com.CoreService.QP.CoreService.model.FavoriteMovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteMovieRepository extends JpaRepository<FavoriteMovieEntity, Integer> {
    FavoriteMovieEntity findByUserIdAndMovieId(int userId, int movieId);
}
