package mk.ukim.finki.moviesapp.domain.movie.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Movie(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @SerializedName("Poster") val posterPath: String,
    val title: String
)