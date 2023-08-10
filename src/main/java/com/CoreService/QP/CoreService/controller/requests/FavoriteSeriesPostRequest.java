package com.CoreService.QP.CoreService.controller.requests;

public class FavoriteSeriesPostRequest {
    private int seriesId;
    private int userId;

    public FavoriteSeriesPostRequest(int seriesId, int userId) {
        this.seriesId = seriesId;
        this.userId = userId;
    }

    public FavoriteSeriesPostRequest() {
    }

    public int getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(int seriesId) {
        this.seriesId = seriesId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
