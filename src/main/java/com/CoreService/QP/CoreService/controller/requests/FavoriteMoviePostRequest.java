package com.CoreService.QP.CoreService.controller.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteMoviePostRequest {
   @NotNull(message = "Movie id cannot be null")
   @Min(value = 1, message = "Movie id must be greater than 0")
    private int movieId;
}
