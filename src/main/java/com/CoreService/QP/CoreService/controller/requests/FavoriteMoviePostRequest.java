package com.CoreService.QP.CoreService.controller.requests;

public class FavoriteMoviePostRequest {
    private int movieId;
    public FavoriteMoviePostRequest(int movieId) {
        this.movieId = movieId;
    }
    public FavoriteMoviePostRequest() {
    }
    public int getMovieId() {
        return movieId;
    }

}
