package com.CoreService.QP.CoreService.controller.response;

import com.CoreService.QP.CoreService.model.FavoriteMovie;
import com.CoreService.QP.CoreService.model.Movie;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MostFavoriteMovie {
    private Integer id;
    private Long count;
    private Movie favoriteMovie;
    public MostFavoriteMovie(Integer id , Long count , Movie movie)
{
        this.id = id;
        this.count = count;
        this.favoriteMovie = movie;
    }
}
