package com.CoreService.QP.CoreService.controller.response;

import com.CoreService.QP.CoreService.model.Series;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class TrendingSeries {
    private Series series;
    private Long count;

    public TrendingSeries(Series series, Long count) {
        this.series = series;
        this.count = count;
    }
}
