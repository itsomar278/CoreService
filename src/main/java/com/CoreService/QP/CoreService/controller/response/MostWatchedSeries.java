package com.CoreService.QP.CoreService.controller.response;

import com.CoreService.QP.CoreService.model.Series;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class MostWatchedSeries {
    private Long count;
    private Series series;

    public MostWatchedSeries(Series series, Long count) {
        this.count = count;
        this.series = series;
    }
}
