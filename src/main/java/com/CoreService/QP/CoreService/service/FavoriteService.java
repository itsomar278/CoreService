package com.CoreService.QP.CoreService.service;

import com.CoreService.QP.CoreService.controller.response.PageResponse;
import com.CoreService.QP.CoreService.exception.customExceptions.EmptyResultException;
import com.CoreService.QP.CoreService.exception.customExceptions.ResourceExistsException;
import com.CoreService.QP.CoreService.exception.customExceptions.ResultNotFoundException;
import com.CoreService.QP.CoreService.model.FavoriteMovie;
import com.CoreService.QP.CoreService.model.FavoriteSeries;
import com.CoreService.QP.CoreService.model.Movie;
import com.CoreService.QP.CoreService.model.Series;
import com.CoreService.QP.CoreService.repository.FavoriteMovieRepository;
import com.CoreService.QP.CoreService.repository.FavoriteSeriesRepository;
import com.CoreService.QP.CoreService.repository.MovieRepository;
import com.CoreService.QP.CoreService.repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavoriteService {
    @Autowired
    private FavoriteMovieRepository favoriteMovieRepository;
    @Autowired
    private FavoriteSeriesRepository favoriteSeriesRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private SeriesRepository seriesRepository;

    public PageResponse findAllFavoriteSeries(int userId , int page , int size) {
        List<FavoriteSeries> result = favoriteSeriesRepository.findByUserId(userId , page , size);

        if (result.isEmpty())
            throw new EmptyResultException("There is No Favorite Series for this User");

        PageResponse pageResponse = new PageResponse();
        pageResponse.setContent(result);
        pageResponse.setCurrentPage(page);
        pageResponse.setSize(size);
        pageResponse.setTotalElements(favoriteSeriesRepository.countByUserId(userId));
        pageResponse.setTotalPages((int) Math.ceil((double) pageResponse.getTotalElements() / size));


        return pageResponse;
    }

    public PageResponse findAllFavoriteMovies(int userId, int page, int size) {
        List<FavoriteMovie> result = favoriteMovieRepository.findByUserId(userId, page, size);

        if (result.isEmpty()) {
            throw new EmptyResultException("There are No Favorite Movies for this User");
        }

        PageResponse pageResponse = new PageResponse();
        pageResponse.setContent(result);
        pageResponse.setCurrentPage(page);
        pageResponse.setSize(size);
        pageResponse.setTotalElements(favoriteMovieRepository.countByUserId(userId));
        pageResponse.setTotalPages((int) Math.ceil((double) pageResponse.getTotalElements() / size));

        return pageResponse;
    }
    public void addFavoriteMovie(FavoriteMovie favoriteMovie) {
        Optional<Movie> movieOptional = movieRepository.findById(favoriteMovie.getMovie().getId());

        if (!movieOptional.isPresent())
            throw new ResultNotFoundException("There is No Movie with this Id");

        favoriteMovie.setMovie(movieOptional.get());
        favoriteMovieRepository.save(favoriteMovie);
    }

    public void addFavoriteSeries(FavoriteSeries favoriteSeries) {
        Optional<Series> seriesOptional = seriesRepository.findById(favoriteSeries.getSeries().getId());

        if (!seriesOptional.isPresent()) {
            throw new ResultNotFoundException("There is No Series with this Id");
        }

        favoriteSeries.setSeries(seriesOptional.get());

        favoriteSeriesRepository.save(favoriteSeries);
    }


    public void deleteFavoriteMovie(FavoriteMovie entity) {
        Optional<FavoriteMovie> favoriteMovie = favoriteMovieRepository.
                findByUserIdAndMovieId(entity.getUserId(), entity.getMovie().getId());

        if (!favoriteMovie.isPresent())
            throw new ResultNotFoundException("There is No Such Movie in your Favorite List");

        favoriteMovieRepository.deleteById(favoriteMovie.get().getId());
    }
    public void deleteFavoriteSeries(FavoriteSeries entity) {
        Optional<FavoriteSeries> favoriteSeries = favoriteSeriesRepository.
                findByUserIdAndSeriesId(entity.getUserId(), entity.getSeries().getId());

        if (!favoriteSeries.isPresent()) {
            throw new ResultNotFoundException("There is No Such Series in your Favorite List");
        }

        favoriteSeriesRepository.deleteById(favoriteSeries.get().getId());
    }
}

