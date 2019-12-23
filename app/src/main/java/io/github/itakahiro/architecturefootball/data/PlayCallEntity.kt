package io.github.itakahiro.architecturefootball.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "play_calls")
data class PlayCallEntity(
    @PrimaryKey
    @ColumnInfo(name = "description")
    val description: String
)