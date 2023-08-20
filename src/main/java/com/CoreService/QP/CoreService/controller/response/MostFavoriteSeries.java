package com.CoreService.QP.CoreService.controller.response;

import com.CoreService.QP.CoreService.model.Series;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MostFavoriteSeries {
    private Series series;
    private Long count;
    public MostFavoriteSeries( Long count , Series series)
    {
        this.series = series;
        this.count = count;
    }
}