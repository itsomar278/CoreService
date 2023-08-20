package com.CoreService.QP.CoreService.controller.response;

import com.CoreService.QP.CoreService.model.Category;
import com.CoreService.QP.CoreService.model.Movie;
import com.CoreService.QP.CoreService.model.MovieCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MostWatchedMovie {
    private Movie movie;
    private Long count;
    public MostWatchedMovie( Movie movie , Long count )
{
        this.movie = movie;
        this.count = count;
    }

}
