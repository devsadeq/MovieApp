package com.karrar.movieapp.data.remote.service

import com.karrar.movieapp.data.remote.response.*
import com.karrar.movieapp.data.remote.response.movieDetailsDto.cast.CreditsDto
import com.karrar.movieapp.data.remote.response.movieDetailsDto.MovieDetailsDto
import com.karrar.movieapp.data.remote.response.movieDetailsDto.RatingDto
import com.karrar.movieapp.data.remote.response.movieDetailsDto.reviews.ReviewsDto
import com.karrar.movieapp.domain.enums.TrendingTimeWindow
import retrofit2.Response
import retrofit2.http.*


interface MovieService {

    @GET("movie/popular")
    suspend fun getPopularMovies(): Response<BaseResponse<MovieDto>>

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(): Response<BaseResponse<MovieDto>>

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(): Response<BaseResponse<MovieDto>>

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(): Response<BaseResponse<MovieDto>>

    @GET("trending/movie/{time_window}")
    suspend fun getTrendingMovies(
        @Path("time_window") timeWindow: String = TrendingTimeWindow.DAY.value,
    ): Response<BaseResponse<MovieDto>>


    @GET("trending/person/{time_window}")
    suspend fun getTrendingPersons(
        @Path("time_window") timeWindow: String = TrendingTimeWindow.DAY.value,
    ): Response<BaseResponse<PersonDto>>


    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movieId: Int,
    ): Response<MovieDetailsDto>


    @GET("movie/{movie_id}/credits")
    suspend fun getMovieCast(
        @Path("movie_id") movieId: Int,
    ): Response<CreditsDto>


    @GET("movie/{movie_id}/similar")
    suspend fun getSimilarMovie(
        @Path("movie_id") movieId: Int,
    ): Response<BaseResponse<MovieDto>>


    @GET("movie/{movie_id}/reviews")
    suspend fun getMovieReviews(
        @Path("movie_id") movieId: Int,
    ): Response<BaseResponse<ReviewsDto>>


    @FormUrlEncoded
    @POST("movie/{movie_id}/rating")
    suspend fun postRating(
        @Path("movie_id") movieId: Int,
        @Field ("value") rating: Float,
        @Query("guest_session_id") apiKey: String?,
        ): Response<RatingDto>

}


