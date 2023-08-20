package com.CoreService.QP.CoreService.controller.response;

import com.CoreService.QP.CoreService.model.Movie;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MostWatchedMovie {
    private Movie movie;
    private Long count;
    public MostWatchedMovie( Movie movie , Long count ) {
        this.movie = movie;
        this.count = count;
    }

}
