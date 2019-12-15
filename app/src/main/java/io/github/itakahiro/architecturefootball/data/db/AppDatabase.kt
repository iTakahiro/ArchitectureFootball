package io.github.itakahiro.architecturefootball.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import io.github.itakahiro.architecturefootball.data.PlayCallEntity

@Database(entities = [PlayCallEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun playCallDao(): PlayCallDao
}