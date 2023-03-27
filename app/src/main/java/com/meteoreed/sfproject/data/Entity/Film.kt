package com.meteoreed.sfproject.data.Entity

import android.media.Rating
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

private const val TITLE = "title"
private const val CACHED_FILMS = "cached_films"
private const val POSTER = "poster"
private const val OVERVIEW = "overview"
private const val VOTE_AVERAGE = "vote_average"

@Parcelize
@Entity (tableName = CACHED_FILMS, indices = [Index(value = [TITLE], unique = true)])
data class Film (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = TITLE) val title: String,
    @ColumnInfo(name = POSTER) val poster: String,
    @ColumnInfo(name = OVERVIEW) val description: String,
    @ColumnInfo(name = VOTE_AVERAGE) val rating: Double = 0.0,
    var isInFavorites: Boolean = false
        ) : Parcelable