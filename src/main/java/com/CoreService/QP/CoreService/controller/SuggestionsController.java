package com.CoreService.QP.CoreService.controller;

import com.CoreService.QP.CoreService.controller.response.*;
import com.CoreService.QP.CoreService.model.Movie;
import com.CoreService.QP.CoreService.model.Series;
import com.CoreService.QP.CoreService.service.WatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SuggestionsController {
    @Autowired
    private WatchService watchService;

    @GetMapping("suggestions/most-favorite/movies")
    public ResponseEntity<Page<Movie>> getMostFavorite(@RequestParam int page , @RequestParam int size)
    {
        Page<Movie> most = watchService.getMostFavoriteMovie(page ,size);
        return new ResponseEntity<>(most, HttpStatus.OK);
    }
    @GetMapping("suggestions/most-Watched/movies")
    public ResponseEntity<Page<Movie>> getMostWatched(@RequestParam int page , @RequestParam int size)
    {
        Page<Movie> most = watchService.getMostWatchedMovie(page ,size);
        return new ResponseEntity<>(most, HttpStatus.OK);
    }

    @GetMapping("suggestions/most-favorite/series")
    public ResponseEntity<Page<Series>> getMostFavoriteSeries(@RequestParam int page , @RequestParam int size)
    {
        Page<Series> most = watchService.getMostFavoriteSeries(page ,size);
        return new ResponseEntity<>(most, HttpStatus.OK);
    }

    @GetMapping("suggestions/most-watched/series")
    public ResponseEntity<Page<Series>> getMostWatchedSeries(@RequestParam int page, @RequestParam int size) {
        Page<Series> mostWatchedSeries = watchService.getMostWatchedSeries(page, size);
        return new ResponseEntity<>(mostWatchedSeries, HttpStatus.OK);
    }

    @GetMapping("suggestions/trending/movie")
    public ResponseEntity<Page<Movie>> getTrendingMovie(@RequestParam int page , @RequestParam int size)
    {
        Page<Movie> trendingMovies = watchService.getTrendingMovie(page ,size);
        return new ResponseEntity<>(trendingMovies, HttpStatus.OK);
    }

    @GetMapping("suggestions/trending/series")
    public ResponseEntity<Page<Series>> getTrendingSeries(@RequestParam int page , @RequestParam int size)
    {
        Page<Series> trendingSeries = watchService.getTrendingSeries(page ,size);
        return new ResponseEntity<>(trendingSeries, HttpStatus.OK);
    }
}
