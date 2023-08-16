package com.CoreService.QP.CoreService.controller;

import com.CoreService.QP.CoreService.controller.requests.FavoriteMovieDeleteRequest;
import com.CoreService.QP.CoreService.controller.requests.FavoriteMoviePostRequest;
import com.CoreService.QP.CoreService.controller.requests.FavoriteSeriesDeleteRequest;
import com.CoreService.QP.CoreService.controller.requests.FavoriteSeriesPostRequest;
import com.CoreService.QP.CoreService.controller.response.FavoriteMovieResponse;
import com.CoreService.QP.CoreService.controller.response.FavoriteSeriesResponse;
import com.CoreService.QP.CoreService.mapper.FavoriteMovieMapper;
import com.CoreService.QP.CoreService.mapper.FavoriteSeriesMapper;
import com.CoreService.QP.CoreService.model.FavoriteMovie;
import com.CoreService.QP.CoreService.model.FavoriteSeries;
import com.CoreService.QP.CoreService.service.FavoriteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.xml.validation.Validator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Validated
public class FavoriteController {
    @Autowired
    private FavoriteService favoriteService;
    @Autowired
    private FavoriteSeriesMapper favoriteSeriesMapper;
    @Autowired
    private FavoriteMovieMapper favoriteMovieMapper;

    @GetMapping("user/{userId}/favorite/series")
    public ResponseEntity<List<FavoriteSeriesResponse>> findAllFavoriteSeries(@PathVariable int userId, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size)
    {       List<FavoriteSeries> favorites = favoriteService.findAllFavoriteSeries(userId , page , size)
                .stream()
                .collect(Collectors.toList());

       List<FavoriteSeriesResponse> result = favoriteSeriesMapper.entityListToResponseList(favorites);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("user/{userId}/favorite/movies")
    public ResponseEntity<List<FavoriteMovieResponse>> findAllFavoriteMovies(@PathVariable int userId, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        List<FavoriteMovie> favorites = favoriteService.findAllFavoriteMovies(userId,page , size)
                .stream()
                .collect(Collectors.toList());

        List<FavoriteMovieResponse> result= favoriteMovieMapper.entityListToResponseList(favorites);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("user/{userId}/favorite/series")
    public ResponseEntity<HttpStatus> addFavoriteSeries(@PathVariable int userId , @RequestBody @Valid FavoriteSeriesPostRequest request) {
        FavoriteSeries dto = favoriteSeriesMapper.requestToEntity(request , userId);
        favoriteService.addFavoriteSeries(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("user/{userId}/favorite/movies")
    public ResponseEntity<HttpStatus> addFavoriteMovie(@PathVariable int userId , @RequestBody @Valid FavoriteMoviePostRequest request)
    {
        FavoriteMovie dto = favoriteMovieMapper.requestToEntity(request , userId);
        favoriteService.addFavoriteMovie(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("user/{userId}/favorite/series")
    public ResponseEntity<HttpStatus> deleteFavoriteSeries(@PathVariable int userId , @RequestBody @Valid FavoriteSeriesDeleteRequest request ) {
        FavoriteSeries dto = favoriteSeriesMapper.requestToEntity(request,userId);
        favoriteService.deleteFavoriteSeries(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("user/{userId}/favorite/movies")
    public ResponseEntity<HttpStatus> deleteFavoriteSeries(@PathVariable int userId , @RequestBody FavoriteMovieDeleteRequest request ) {
        FavoriteMovie dto = favoriteMovieMapper.requestToEntity(request,userId);
        favoriteService.deleteFavoriteMovie(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
