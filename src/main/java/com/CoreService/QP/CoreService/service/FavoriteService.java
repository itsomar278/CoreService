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
                .filter(favoriteMovie -> favoriteMovie.getId() == userId)
                .collect(Collectors.toList());

        if (result.isEmpty())
            throw new EmptyResultException("There is No Favorite Movies for this User");

        return result;
    }

    public void addFavoriteMovie(FavoriteMovieEntity favoriteMovie) {
        Optional<MovieEntity> movieOptional = movieRepository.findById(favoriteMovie.getMovie().getId());
        if (!movieOptional.isPresent())
            throw new ResultNotFoundException("There is No Movie with this Id");

       /* List<FavoriteMovieEntity> existingFavorites = favoriteMovieRepository.findByUserIdAndMovieId(
                favoriteMovie.getUserId(), favoriteMovie.getMovie().getId());

        if (!existingFavorites.isEmpty())
            throw new ResourceExistsException("This Movie is already in your Favorite List");


        favoriteMovie.setMovie(movieOptional.get());
        favoriteMovieRepository.save(favoriteMovie);*/
    }

    public void addFavoriteSeries(FavoriteSeriesEntity favoriteSeries) {
        Optional<SeriesEntity> seriesOptional = seriesRepository.findById(favoriteSeries.getSeries().getId());
        if (!seriesOptional.isPresent()) {
            throw new ResultNotFoundException("There is No Series with this Id");
        }

      /*  List<FavoriteSeriesEntity> existingFavorites = favoriteSeriesRepository.findByUserIdAndSeriesId(
                favoriteSeries.getUserId(), favoriteSeries.getSeries().getId());

        if (!existingFavorites.isEmpty()) {
            throw new ResourceExistsException("This Series is already in your Favorite List");
        }

        favoriteSeries.setSeries(seriesOptional.get());
        favoriteSeriesRepository.save(favoriteSeries);

       */
    }


    public void deleteFavoriteMovieById(int id) {
        if(!favoriteMovieRepository.existsById(id))
            throw new ResultNotFoundException("There is No Such Movie in your Favorite List");

        favoriteMovieRepository.deleteById(id);
    }
    public void deleteFavoriteSeriesById(int id) {
        if(!favoriteMovieRepository.existsById(id))
            throw new ResultNotFoundException("There is No Such Movie in your Favorite List");

        favoriteSeriesRepository.deleteById(id);
    }
}

