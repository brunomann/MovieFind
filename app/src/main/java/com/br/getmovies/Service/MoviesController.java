package com.br.getmovies.Service;

import com.br.getmovies.Data.MoviesDTO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MoviesController {


    @GET("popular")
    Call<MoviesDTO> getApiPopularMovies(@Query("api_key") String apiKey);

    @GET("top_rated")
    Call<MoviesDTO> getApiTopRatedMovies(@Query("api_key")String apiKey);

    @GET("{movie_id}/similar")
    Call<MoviesDTO> getApiSimilarMovies(@Path("movie_id") String id, @Query("api_key")String apiKey);
}
