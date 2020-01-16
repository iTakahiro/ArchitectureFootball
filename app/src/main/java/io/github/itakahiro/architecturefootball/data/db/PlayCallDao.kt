package io.github.itakahiro.architecturefootball.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.github.itakahiro.architecturefootball.data.PlayCallEntity

@Dao
interface PlayCallDao {
    @Query("SELECT * FROM play_calls")
    suspend fun loadAllPlayCall(): List<PlayCallEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePlayCall(playCallEntity: PlayCallEntity)
}