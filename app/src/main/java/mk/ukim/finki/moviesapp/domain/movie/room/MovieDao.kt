package mk.ukim.finki.moviesapp.domain.movie.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import mk.ukim.finki.moviesapp.domain.movie.model.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movie: Movie)

    @Delete()
    suspend fun delete(movie: Movie)

    @Query("DELETE FROM movie where id=:id")
    suspend fun delete(id: Int)

    @Query("SELECT * FROM movie")
    suspend fun getAll(): List<Movie>

    @Query("SELECT * FROM movie WHERE title LIKE :query")
    suspend fun searchMovies(query: String): List<Movie>
}