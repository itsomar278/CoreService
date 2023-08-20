package com.CoreService.QP.CoreService.service;

import com.CoreService.QP.CoreService.controller.response.*;
import com.CoreService.QP.CoreService.exception.customExceptions.EmptyResultException;
import com.CoreService.QP.CoreService.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class WatchService {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private SeriesRepository seriesRepository;
    @Autowired
    private FavoriteMovieRepository favoriteMovieRepository;
    @Autowired
    private FavoriteSeriesRepository favoriteSeriesRepository;
    @Autowired
    private WatchingEpisodeRepository watchingEpisodeRepository;
    @Autowired
    private WatchingMovieRepository watchingMovieRepository;


    public Page<MostFavoriteMovie> getMostFavoriteMovie(int page, int size) {
        Page<MostFavoriteMovie> mostFavoriteMovies = favoriteMovieRepository.findMostFavorite(PageRequest.of(page, size));

        if (mostFavoriteMovies.hasContent())
            return mostFavoriteMovies;

        throw new EmptyResultException("There is No Favorite Movies");
    }

    public Page<MostWatchedMovie> getMostWatchedMovie(int page, int size) {
        Page<MostWatchedMovie> mostWatchedMovies = watchingMovieRepository.findMostWatched(PageRequest.of(page, size));

        if (mostWatchedMovies.hasContent())
            return mostWatchedMovies;

        throw new EmptyResultException("There is No Watched Movies");
    }

    public Page<MostFavoriteSeries> getMostFavoriteSeries(int page, int size) {
        Page<MostFavoriteSeries> mostFavoriteSeriesPage = favoriteSeriesRepository.findMostFavoriteSeries(PageRequest.of(page, size));

        if (mostFavoriteSeriesPage.hasContent())
            return mostFavoriteSeriesPage;

        throw new EmptyResultException("There is No Favorite Series");
    }

    public Page<MostWatchedSeries> getMostWatchedSeries(int page, int size) {
        Page<MostWatchedSeries> mostWatchedSeriesPage = watchingEpisodeRepository.findMostWatchedSeries(PageRequest.of(page, size));

        if (mostWatchedSeriesPage.hasContent())
            return mostWatchedSeriesPage;

        throw new EmptyResultException("There is No Watched Series");

    }

    public Page<TrendingMovie> getTrendingMovie(int page , int size)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.WEEK_OF_YEAR, -1); // Subtract one week
        Date lastWeekStartDate = calendar.getTime();

        Page<TrendingMovie> trendingMovies = watchingMovieRepository.findTrendingMovie(PageRequest.of(page, size) ,lastWeekStartDate );

        if (trendingMovies.hasContent())
            return trendingMovies;

        throw new EmptyResultException("There is No Trending Movies");
    }

    public Page<TrendingSeries> getTrendingSeries(int page , int size)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.WEEK_OF_YEAR, -1); // Subtract one week
        Date lastWeekStartDate = calendar.getTime();

            Page<TrendingSeries> trendingSeries = watchingEpisodeRepository.findTrendingSeries(PageRequest.of(page, size) ,lastWeekStartDate );

            if (trendingSeries.hasContent())
                return trendingSeries;

            throw new EmptyResultException("There is No Trending Series");
    }
}
