package com.karrar.movieapp.data.repository

import com.karrar.movieapp.data.local.database.entity.SearchHistoryEntity
import com.karrar.movieapp.data.local.database.entity.WatchHistoryEntity
import com.karrar.movieapp.data.remote.State
import com.karrar.movieapp.data.remote.response.*
import com.karrar.movieapp.data.remote.response.movie.RatedMovie
import com.karrar.movieapp.domain.models.*
import com.karrar.movieapp.data.remote.response.movie.RatingDto
import com.karrar.movieapp.domain.models.ActorDetails
import com.karrar.movieapp.domain.models.Actor
import com.karrar.movieapp.domain.models.Genre
import com.karrar.movieapp.domain.models.Media
import com.karrar.movieapp.domain.models.PopularMovie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    fun getPopularMovies(): Flow<State<List<PopularMovie>>>

    fun getUpcomingMovies(): Flow<State<List<Media>>>

    fun getTopRatedMovies(): Flow<State<List<Media>>>

    fun getNowPlayingMovies(): Flow<State<List<Media>>>

    fun getTrendingMovies(): Flow<State<List<Media>>>

    suspend fun searchForActor(query: String): List<Media>

    suspend fun searchForMovie(query: String): List<Media>

    suspend fun searchForSeries(query: String): List<Media>

    fun getMovieGenreList(): Flow<State<List<Genre>>>

    fun getMovieListByGenreID(genreID: Int): Flow<State<List<Media>>>

    fun getActorDetails(actorId: Int): Flow<State<ActorDetails>>

    suspend fun insertSearchItem(item: SearchHistoryEntity)

    suspend fun deleteSearchItem(item: SearchHistoryEntity)

    fun getAllSearchHistory(): Flow<List<SearchHistory>>

    fun getTrendingActors(): Flow<State<List<Actor>>>

    fun getActorMovies(actorId: Int): Flow<State<List<Media>>>

    suspend fun getDailyTrending(): List<Media>

    fun getAllMovies(): Flow<State<List<Media>>>

    fun getMovieDetails(movieId: Int): Flow<State<MovieDetails>>

    fun getMovieCast(movieId: Int): Flow<State<List<Actor>>>

    fun getSimilarMovie(movieId: Int): Flow<State<List<Media>>>

    fun getMovieReviews(movieId: Int): Flow<State<List<Review>>>

    fun setRating(movieId: Int, value:Float, session_id: String): Flow<State<RatingDto>>

    suspend fun getMovieTrailer(movieId: Int): Flow<State<Trailer>>

    fun getAllLists(accountId: Int, sessionId:String): Flow<State<BaseResponse<CreatedListDto>>>

    fun addMovieToList(sessionId: String, listId: Int, movieId: Int): Flow<State<AddMovieDto>>

    fun getListDetails(listId: Int): Flow<State<ListDetailsDto>>

    fun getRatedMovie(accountId: Int, sessionId: String): Flow<State<BaseResponse<RatedMovie>>>

    fun getAccountDetails(sessionId: String): Flow<State<Account>>

    fun getRatedMovies(sessionId: String?): Flow<State<List<RatedMovies>>>

    suspend fun insertMovie(movie: WatchHistoryEntity)

    fun getAllWatchedMovies(): Flow<List<WatchHistoryEntity>>

    suspend fun clearWatchHistory()
}