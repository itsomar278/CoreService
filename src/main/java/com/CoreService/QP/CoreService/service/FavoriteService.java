package com.CoreService.QP.CoreService.service;

import com.CoreService.QP.CoreService.exception.customExceptions.EmptyResultException;
import com.CoreService.QP.CoreService.exception.customExceptions.ResourceExistsException;
import com.CoreService.QP.CoreService.exception.customExceptions.ResultNotFoundException;
import com.CoreService.QP.CoreService.model.FavoriteMovieEntity;
import com.CoreService.QP.CoreService.model.FavoriteSeriesEntity;
import com.CoreService.QP.CoreService.model.MovieEntity;
import com.CoreService.QP.CoreService.model.SeriesEntity;
import com.CoreService.QP.CoreService.repository.FavoriteMovieRepository;
import com.CoreService.QP.CoreService.repository.FavoriteSeriesRepository;
import com.CoreService.QP.CoreService.repository.MovieRepository;
import com.CoreService.QP.CoreService.repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<FavoriteSeriesEntity> findAllFavoriteSeries(int userId) {
        List<FavoriteSeriesEntity> result = favoriteSeriesRepository.findAll()
                .stream()
                .filter(favoriteSeries -> favoriteSeries.getUserId() == userId)
                .collect(Collectors.toList());

        if (result.isEmpty())
            throw new EmptyResultException("There is No Favorite Series for this User");

        return result;
    }

    public List<FavoriteMovieEntity> findAllFavoriteMovies(int userId) {
        List<FavoriteMovieEntity> result = favoriteMovieRepository.findAll()
                .stream()
                .filter(favoriteMovie -> favoriteMovie.getUserId() == userId)
                .collect(Collectors.toList());

        if (result.isEmpty())
            throw new EmptyResultException("There is No Favorite Movies for this User");

        return result;
    }

    public void addFavoriteMovie(FavoriteMovieEntity favoriteMovie) {
        Optional<MovieEntity> movieOptional = movieRepository.findById(favoriteMovie.getMovie().getId());

        if (!movieOptional.isPresent())
            throw new ResultNotFoundException("There is No Movie with this Id");

        favoriteMovie.setMovie(movieOptional.get());
        Optional<FavoriteMovieEntity> existingFavorite = Optional.ofNullable(favoriteMovieRepository.findByUserIdAndMovieId(
                favoriteMovie.getUserId(), favoriteMovie.getMovie().getId()));

        if (existingFavorite.isPresent()) {
            throw new ResourceExistsException("This Series is already in your Favorite List");
        }

        favoriteMovieRepository.save(favoriteMovie);
    }

    public void addFavoriteSeries(FavoriteSeriesEntity favoriteSeries) {
        Optional<SeriesEntity> seriesOptional = seriesRepository.findById(favoriteSeries.getSeries().getId());

        if (!seriesOptional.isPresent()) {
            throw new ResultNotFoundException("There is No Series with this Id");
        }

        favoriteSeries.setSeries(seriesOptional.get());
        Optional<FavoriteSeriesEntity> existingFavorite = Optional.ofNullable(favoriteSeriesRepository.findByUserIdAndSeriesId(
                favoriteSeries.getUserId(), favoriteSeries.getSeries().getId()));

        if (existingFavorite.isPresent()) {
            throw new ResourceExistsException("This Series is already in your Favorite List");
        }

        favoriteSeriesRepository.save(favoriteSeries);
    }


    public void deleteFavoriteMovie(FavoriteMovieEntity entity) {
        Optional<FavoriteMovieEntity> favoriteMovie = Optional.ofNullable(favoriteMovieRepository.
                findByUserIdAndMovieId(entity.getUserId(), entity.getMovie().getId()));

        if (!favoriteMovie.isPresent())
            throw new ResultNotFoundException("There is No Such Movie in your Favorite List");

        favoriteMovieRepository.deleteById(favoriteMovie.get().getId());
    }
    public void deleteFavoriteSeries(FavoriteSeriesEntity entity) {
        Optional<FavoriteSeriesEntity> favoriteSeries = Optional.ofNullable(favoriteSeriesRepository.
                findByUserIdAndSeriesId(entity.getUserId(), entity.getSeries().getId()));

        if (!favoriteSeries.isPresent()) {
            throw new ResultNotFoundException("There is No Such Series in your Favorite List");
        }

        favoriteSeriesRepository.deleteById(favoriteSeries.get().getId());
    }
}

