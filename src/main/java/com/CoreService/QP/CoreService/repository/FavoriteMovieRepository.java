package com.CoreService.QP.CoreService.repository;

import com.CoreService.QP.CoreService.model.FavoriteMovie;
import com.CoreService.QP.CoreService.model.FavoriteSeries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavoriteMovieRepository extends JpaRepository<FavoriteMovie, Integer> {
    @Query(value = "SELECT * FROM core.favorite_movie WHERE user_id = ?1 AND movie_id = ?2 AND is_deleted = false", nativeQuery = true)
    Optional<FavoriteMovie> findByUserIdAndMovieId(int userId, int movieId);

    @Query(value = "SELECT * FROM core.favorite_movie WHERE user_id = ?1 AND is_deleted = false LIMIT ?3 OFFSET ?2 * ?3 ", nativeQuery = true)
    List<FavoriteMovie> findByUserId(int userId ,int page , int size);

    @Modifying
    @Query(value = "UPDATE core.favorite_movie SET is_deleted = true WHERE id = ?", nativeQuery = true)
    @Override
    void deleteById(Integer integer);

    @Query(value = "SELECT COUNT(*) FROM core.favorite_movie WHERE is_deleted = false AND user_id = ?1", nativeQuery = true)
    int countByUserId(int userId);


}
