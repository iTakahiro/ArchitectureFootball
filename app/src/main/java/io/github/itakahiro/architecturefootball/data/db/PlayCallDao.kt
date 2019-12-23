package io.github.itakahiro.architecturefootball.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.github.itakahiro.architecturefootball.data.PlayCallEntity

@Dao
interface PlayCallDao {
    @Query("SELECT * FROM play_call")
    fun loadAllPlayCall(): List<PlayCallEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun savePlayCall(playCallEntity: PlayCallEntity)
}