package com.CoreService.QP.CoreService.repository;

import com.CoreService.QP.CoreService.model.FavoriteMovie;
import com.CoreService.QP.CoreService.model.FavoriteSeries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteMovieRepository extends JpaRepository<FavoriteMovie, Integer> {
    @Query(value = "SELECT * FROM core.favorite_movie WHERE user_id = ?1 AND movie_id = ?2", nativeQuery = true)
    FavoriteMovie findByUserIdAndMovieId(int userId, int movieId);

    @Query(value = "SELECT * FROM core.favorite_movie WHERE user_id = ?1", nativeQuery = true)
    List<FavoriteMovie> findByUserId(int userId);
}
