package io.github.itakahiro.architecturefootball.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "PLAY_CALL")
data class PlayCallEntity(
    @PrimaryKey
    @ColumnInfo(name = "description")
    val description: String
)