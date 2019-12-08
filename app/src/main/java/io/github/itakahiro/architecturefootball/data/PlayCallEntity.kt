package io.github.itakahiro.databindingfootball.data

import androidx.room.Entity

@Entity(tableName = "PLAY_CALL")
data class PlayCallEntity(
    val id: Int,
    val description: String
)