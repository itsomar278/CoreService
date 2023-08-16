package com.CoreService.QP.CoreService.service;

import com.CoreService.QP.CoreService.controller.response.PageResponse;
import com.CoreService.QP.CoreService.exception.customExceptions.EmptyResultException;
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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;


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
        Pageable pagination = PageRequest.of(page, size);
        List<FavoriteSeries> result = favoriteSeriesRepository.findByUserId(userId , pagination);

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
        Pageable pagination = PageRequest.of(page, size);
        List<FavoriteMovie> result = favoriteMovieRepository.findByUserId(userId,pagination);

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
        Integer movieId = favoriteMovie.getMovie().getId();

        Movie movieOptional = movieRepository.findById(movieId)
                .orElseThrow(() ->new ResultNotFoundException("There is No Movie with this Id"));


        favoriteMovie.setMovie(movieOptional);
        favoriteMovieRepository.save(favoriteMovie);
    }

    public void addFavoriteSeries(FavoriteSeries favoriteSeries) {
        Integer seriesId = favoriteSeries.getSeries().getId();

        Series seriesOptional = seriesRepository.findById(seriesId)
                .orElseThrow(() -> new ResultNotFoundException("There is No Series with this Id"));

        favoriteSeries.setSeries(seriesOptional);

        favoriteSeriesRepository.save(favoriteSeries);
    }


    public void deleteFavoriteMovie(FavoriteMovie entity) {
        FavoriteMovie favoriteMovie = favoriteMovieRepository.
                findByUserIdAndMovieId(entity.getUserId(), entity.getMovie().getId())
                .orElseThrow(() -> new ResultNotFoundException("There is No Such Movie in your Favorite List"));

        favoriteMovieRepository.deleteById(favoriteMovie.getId());
    }
    public void deleteFavoriteSeries(FavoriteSeries entity) {
        FavoriteSeries favoriteSeries = favoriteSeriesRepository.
                findByUserIdAndSeriesId(entity.getUserId(), entity.getSeries().getId())
                .orElseThrow(()-> new ResultNotFoundException("There is No Such Series in your Favorite List"));

        favoriteSeriesRepository.deleteById(favoriteSeries.getId());
    }
}

