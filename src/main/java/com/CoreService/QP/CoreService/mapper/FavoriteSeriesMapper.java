package com.CoreService.QP.CoreService.mapper;

import com.CoreService.QP.CoreService.controller.requests.FavoriteSeriesDeleteRequest;
import com.CoreService.QP.CoreService.controller.requests.FavoriteSeriesPostRequest;
import com.CoreService.QP.CoreService.model.FavoriteSeriesEntity;
import com.CoreService.QP.CoreService.model.SeriesEntity;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring" , injectionStrategy = InjectionStrategy.FIELD)
public interface FavoriteSeriesMapper {
    @BeforeMapping
    default void initializeSeries(FavoriteSeriesPostRequest request, @MappingTarget FavoriteSeriesEntity entity) {
        entity.setSeries(new SeriesEntity());
    }

    @Mappings({
            @Mapping(target = "series.id", source = "request.seriesId"),
            @Mapping(target = "userId", source = "userId")
    })
    FavoriteSeriesEntity requestToEntity(FavoriteSeriesPostRequest request, int userId);

    @BeforeMapping
    default void initializeSeries(FavoriteSeriesDeleteRequest request, @MappingTarget FavoriteSeriesEntity entity) {
        entity.setSeries(new SeriesEntity());
    }

    @Mappings({
            @Mapping(target = "series.id", source = "request.seriesId"),
            @Mapping(target = "userId", source = "userId")
    })
    FavoriteSeriesEntity requestToEntity(FavoriteSeriesDeleteRequest request, int userId);
}
