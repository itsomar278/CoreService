package com.CoreService.QP.CoreService.repository;

import com.CoreService.QP.CoreService.model.FavoriteMovieEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

public class FavoriteMovieRepositoryImpl {

    @PersistenceContext
    private EntityManager entityManager;

    @Lazy
    @Autowired
    private FavoriteMovieRepository favoriteMovieRepository;

    FavoriteMovieEntity findByUserIdAndMovieId(int userId, int movieId)
    {
        String hql = "SELECT fm FROM FavoriteMovieEntity fm WHERE fm.userId = :userId AND fm.movie.id = :movieId";
        TypedQuery<FavoriteMovieEntity> query = entityManager.createQuery(hql, FavoriteMovieEntity.class);
        query.setParameter("userId", userId);
        query.setParameter("movieId", movieId);
        return query.getSingleResult();
    }
}
