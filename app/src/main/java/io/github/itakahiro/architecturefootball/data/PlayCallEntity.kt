package io.github.itakahiro.architecturefootball.data

import androidx.room.Entity

@Entity(tableName = "PLAY_CALL")
data class PlayCallEntity(
    val id: Int,
    val description: String
)