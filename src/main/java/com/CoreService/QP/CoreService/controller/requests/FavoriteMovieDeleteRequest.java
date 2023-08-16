package com.CoreService.QP.CoreService.controller.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class FavoriteMovieDeleteRequest {
    @NotNull(message = "Movie id cannot be null")
    @NotBlank(message = "Movie id cannot be blank")
    private int movieId ;
}
