package com.CoreService.QP.CoreService.mapper;

import com.CoreService.QP.CoreService.controller.requests.FavoriteSeriesDeleteRequest;
import com.CoreService.QP.CoreService.controller.requests.FavoriteSeriesPostRequest;
import com.CoreService.QP.CoreService.controller.response.FavoriteSeriesResponse;
import com.CoreService.QP.CoreService.model.FavoriteSeries;
import com.CoreService.QP.CoreService.model.Series;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring" , injectionStrategy = InjectionStrategy.FIELD)
public interface FavoriteSeriesMapper {

    @Mapping(target = "series.id", source = "request.seriesId")
    @Mapping(target = "userId", source = "userId")
    FavoriteSeries requestToEntity(FavoriteSeriesPostRequest request, int userId);

    @Mapping(target = "series.id", source = "request.seriesId")
    @Mapping(target = "userId", source = "userId")
    FavoriteSeries requestToEntity(FavoriteSeriesDeleteRequest request, int userId);

    @Mapping(target = "seriesId", source = "series.id")
    @Mapping(target = "seriesName", source = "series.name")
    List<FavoriteSeriesResponse> entityListToResponseList(List<FavoriteSeries> entityList);

    @Mapping(target = "seriesId", source = "series.id")
    @Mapping(target = "seriesName", source = "series.name")
    FavoriteSeriesResponse entityToResponse(FavoriteSeries entity);
}
