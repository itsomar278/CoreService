package com.CoreService.QP.CoreService.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.CoreService.QP.CoreService.model.FavoriteMovie;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavoriteMovieRepository extends PagingAndSortingRepository<FavoriteMovie, Integer> , CrudRepository<FavoriteMovie, Integer> {

    @Query("SELECT fm FROM FavoriteMovie fm WHERE fm.userId = ?1 AND fm.movie.id = ?2 AND fm.isDeleted = false")
    Optional<FavoriteMovie> findByUserIdAndMovieId(int userId, int movieId);

    @Query(value = "SELECT fm FROM FavoriteMovie fm WHERE fm.userId = ?1 AND fm.isDeleted = false")
    List<FavoriteMovie> findByUserId(int userId , Pageable pageable);

    @Modifying
    @Query("UPDATE FavoriteMovie fm SET fm.isDeleted = true WHERE fm.id = ?1")
    @Override
    void deleteById(Integer integer);

    @Query("SELECT COUNT(fm) FROM FavoriteMovie fm WHERE fm.isDeleted = false AND fm.userId = ?1")
    int countByUserId(int userId);
}
