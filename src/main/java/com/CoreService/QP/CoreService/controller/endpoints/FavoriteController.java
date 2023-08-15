package com.CoreService.QP.CoreService.controller.endpoints;

import com.CoreService.QP.CoreService.controller.requests.FavoriteMovieDeleteRequest;
import com.CoreService.QP.CoreService.controller.requests.FavoriteMoviePostRequest;
import com.CoreService.QP.CoreService.controller.requests.FavoriteSeriesDeleteRequest;
import com.CoreService.QP.CoreService.controller.requests.FavoriteSeriesPostRequest;
import com.CoreService.QP.CoreService.controller.response.FavoriteMovieResponse;
import com.CoreService.QP.CoreService.controller.response.FavoriteSeriesResponse;
import com.CoreService.QP.CoreService.mapper.FavoriteMovieMapper;
import com.CoreService.QP.CoreService.mapper.FavoriteSeriesMapper;
import com.CoreService.QP.CoreService.model.FavoriteMovieEntity;
import com.CoreService.QP.CoreService.model.FavoriteSeriesEntity;
import com.CoreService.QP.CoreService.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FavoriteController {
    @Autowired
    private FavoriteService favoriteService;
    @Autowired
    private FavoriteSeriesMapper favoriteSeriesMapper;
    @Autowired
    private FavoriteMovieMapper favoriteMovieMapper;

    @GetMapping("user/{userId}/favorite/series")
    public ResponseEntity<List<FavoriteSeriesResponse>> findAllFavoriteSeries(@PathVariable int userId) {
       var result = favoriteService.findAllFavoriteSeries(userId)
                .stream()
                .map(favoriteSeries -> new FavoriteSeriesResponse(favoriteSeries.getSeries().getId(),
                        favoriteSeries.getSeries().getName()))
                .collect(Collectors.toList());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("user/{userId}/favorite/movies")
    public ResponseEntity<List<FavoriteMovieResponse>> findAllFavoriteMovies(@PathVariable int userId) {
        var result = favoriteService.findAllFavoriteMovies(userId)
                .stream()
                .map(favoriteMovie -> new FavoriteMovieResponse(favoriteMovie.getMovie().getId(),
                        favoriteMovie.getMovie().getName()))
                .collect(Collectors.toList());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("user/{userId}/favorite/series")
    public ResponseEntity addFavoriteSeries(@PathVariable int userId , @RequestBody FavoriteSeriesPostRequest request) {
        FavoriteSeriesEntity dto = favoriteSeriesMapper.requestToEntity(request , userId);
        favoriteService.addFavoriteSeries(dto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("user/{userId}/favorite/movies")
    public ResponseEntity addFavoriteMovie(@PathVariable int userId , @RequestBody FavoriteMoviePostRequest request)
    {
        FavoriteMovieEntity dto = favoriteMovieMapper.requestToEntity(request , userId);
        favoriteService.addFavoriteMovie(dto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("user/{userId}/favorite/series")
    public ResponseEntity deleteFavoriteSeries(@PathVariable int userId , @RequestBody FavoriteSeriesDeleteRequest request ) {
        FavoriteSeriesEntity dto = favoriteSeriesMapper.requestToEntity(request,userId);
        favoriteService.deleteFavoriteSeries(dto);
        return new ResponseEntity(HttpStatus.OK);
    }
    @DeleteMapping("user/{userId}/favorite/movies")
    public ResponseEntity deleteFavoriteSeries(@PathVariable int userId , @RequestBody FavoriteMovieDeleteRequest request ) {
        FavoriteMovieEntity dto = favoriteMovieMapper.requestToEntity(request,userId);
        favoriteService.deleteFavoriteMovie(dto);
        return new ResponseEntity(HttpStatus.OK);
    }








}
