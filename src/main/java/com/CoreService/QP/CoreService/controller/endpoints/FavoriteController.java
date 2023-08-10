package com.CoreService.QP.CoreService.controller.endpoints;

import com.CoreService.QP.CoreService.controller.response.FavoriteSeriesResponse;
import com.CoreService.QP.CoreService.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FavoriteController {
    @Autowired
    private FavoriteService favoriteService;

    @GetMapping("user/{userId}/favorite/series")
    public ResponseEntity<List<FavoriteSeriesResponse>> findAllFavoriteSeries(@PathVariable int userId) {
       var result = favoriteService.findAllFavoriteSeries(userId)
                .stream()
                .map(favoriteSeries -> new FavoriteSeriesResponse(favoriteSeries.getSeries().getId(),
                        favoriteSeries.getSeries().getName()))
                .collect(Collectors.toList());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
