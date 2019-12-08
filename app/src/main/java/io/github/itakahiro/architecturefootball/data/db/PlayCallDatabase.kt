package io.github.itakahiro.databindingfootball.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import io.github.itakahiro.databindingfootball.data.PlayCallEntity

@Database(entities = [PlayCallEntity::class], version = 1)
abstract class PlayCallDatabase() : RoomDatabase()