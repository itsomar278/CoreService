package com.CoreService.QP.CoreService.mapper;

import com.CoreService.QP.CoreService.controller.requests.FavoriteMovieDeleteRequest;
import com.CoreService.QP.CoreService.controller.requests.FavoriteMoviePostRequest;
import com.CoreService.QP.CoreService.controller.response.FavoriteMovieResponse;
import com.CoreService.QP.CoreService.model.FavoriteMovie;
import com.CoreService.QP.CoreService.model.Movie;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface FavoriteMovieMapper {

    @Mapping(target = "movie.id", source = "request.movieId")
    @Mapping(target = "userId", source = "userId")
    FavoriteMovie requestToEntity(FavoriteMoviePostRequest request, int userId);
    @Mapping(target = "movie.id", source = "request.movieId")
    @Mapping(target = "userId", source = "userId")
    FavoriteMovie requestToEntity(FavoriteMovieDeleteRequest request, int userId);

    @Mapping(target = "movieId", source = "movie.id")
    @Mapping(target = "movieName", source = "movie.name")
    List<FavoriteMovieResponse> entityListToResponseList(List<FavoriteMovie> entityList);
    @Mapping(target = "movieId", source = "movie.id")
    @Mapping(target = "movieName", source = "movie.name")
    FavoriteMovieResponse entityToResponse(FavoriteMovie entity);
}
