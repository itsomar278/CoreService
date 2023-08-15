package com.CoreService.QP.CoreService.controller.requests;

public class FavoriteSeriesPostRequest {
    private int seriesId;

    public FavoriteSeriesPostRequest( int seriesId) {
        this.seriesId = seriesId;
    }

    public FavoriteSeriesPostRequest() {
    }
    public int getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(int seriesId) {
        this.seriesId = seriesId;
    }
}
