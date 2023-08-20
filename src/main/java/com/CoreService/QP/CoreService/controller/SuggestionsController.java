package com.CoreService.QP.CoreService.controller;

import com.CoreService.QP.CoreService.controller.response.*;
import com.CoreService.QP.CoreService.model.Movie;
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
    public ResponseEntity<Page<MostWatchedMovie>> getMostWatched(@RequestParam int page , @RequestParam int size)
    {
        Page<MostWatchedMovie> most = watchService.getMostWatchedMovie(page ,size);
        return new ResponseEntity<>(most, HttpStatus.OK);
    }

    @GetMapping("suggestions/most-favorite/series")
    public ResponseEntity<Page<MostFavoriteSeries>> getMostFavoriteSeries(@RequestParam int page , @RequestParam int size)
    {
        Page<MostFavoriteSeries> most = watchService.getMostFavoriteSeries(page ,size);
        return new ResponseEntity<>(most, HttpStatus.OK);
    }

    @GetMapping("suggestions/most-watched/series")
    public ResponseEntity<Page<MostWatchedSeries>> getMostWatchedSeries(@RequestParam int page, @RequestParam int size) {
        Page<MostWatchedSeries> mostWatchedSeries = watchService.getMostWatchedSeries(page, size);
        return new ResponseEntity<>(mostWatchedSeries, HttpStatus.OK);
    }

    @GetMapping("suggestions/trending/movie")
    public ResponseEntity<Page<TrendingMovie>> getTrendingMovie(@RequestParam int page , @RequestParam int size)
    {
        Page<TrendingMovie> trendingMovies = watchService.getTrendingMovie(page ,size);
        return new ResponseEntity<>(trendingMovies, HttpStatus.OK);
    }

    @GetMapping("suggestions/trending/series")
    public ResponseEntity<Page<TrendingSeries>> getTrendingSeries(@RequestParam int page , @RequestParam int size)
    {
        Page<TrendingSeries> trendingSeries = watchService.getTrendingSeries(page ,size);
        return new ResponseEntity<>(trendingSeries, HttpStatus.OK);
    }
}
