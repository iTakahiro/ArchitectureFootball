package io.github.itakahiro.architecturefootball.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "PLAY_CALL")
data class PlayCallEntity(
    @PrimaryKey
    val id: Int = 0,
    val description: String
)