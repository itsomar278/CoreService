package com.CoreService.QP.CoreService.mapper;

import com.CoreService.QP.CoreService.controller.requests.FavoriteMovieDeleteRequest;
import com.CoreService.QP.CoreService.controller.requests.FavoriteMoviePostRequest;
import com.CoreService.QP.CoreService.model.FavoriteMovieEntity;
import com.CoreService.QP.CoreService.model.MovieEntity;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface FavoriteMovieMapper {
    @BeforeMapping
    default void initializeMovie(FavoriteMoviePostRequest request, @MappingTarget FavoriteMovieEntity entity) {
        entity.setMovie(new MovieEntity());
    }

    @Mappings({
            @Mapping(target = "movie.id", source = "request.movieId"),
            @Mapping(target = "userId", source = "userId")
    })
    FavoriteMovieEntity requestToEntity(FavoriteMoviePostRequest request, int userId);

    @BeforeMapping
    default void initializeMovie(FavoriteMovieDeleteRequest request, @MappingTarget FavoriteMovieEntity entity) {
        entity.setMovie(new MovieEntity());
    }

    @Mappings({
            @Mapping(target = "movie.id", source = "request.movieId"),
            @Mapping(target = "userId", source = "userId")
    })
    FavoriteMovieEntity requestToEntity(FavoriteMovieDeleteRequest request, int userId);
}
