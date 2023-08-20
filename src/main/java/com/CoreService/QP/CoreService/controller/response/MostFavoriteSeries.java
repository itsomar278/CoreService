package com.CoreService.QP.CoreService.controller.response;

import com.CoreService.QP.CoreService.model.Series;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MostFavoriteSeries {
    private Series series;
    private Long count;

    public MostFavoriteSeries( Long count , Series series)
    {
        this.series = series;
        this.count = count;
    }
}