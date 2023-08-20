package com.CoreService.QP.CoreService.controller.response;

import com.CoreService.QP.CoreService.model.Movie;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class TrendingMovie {
    private Movie movie;
    private Long count;
    public TrendingMovie( Movie movie , Long count ) {
        this.movie = movie;
        this.count = count;
    }
}
