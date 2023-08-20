package com.CoreService.QP.CoreService.controller.requests;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FavoriteSeriesDeleteRequest {
    @NotNull(message = "Series id cannot be null")
    private int seriesId ;
}
