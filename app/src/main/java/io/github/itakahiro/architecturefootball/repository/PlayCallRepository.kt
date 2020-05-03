package io.github.itakahiro.architecturefootball.repository

import io.github.itakahiro.architecturefootball.data.PlayCallEntity
import io.github.itakahiro.architecturefootball.data.db.PlayCallDao

class PlayCallRepository (
    private val dao: PlayCallDao
) {
    // Field Injection
//    @Inject
//    lateinit var dao: PlayCallDao
//    init {
//        DaggerAppComponent.create().inject(this)
//    }

    suspend fun loadAllPlayCall(): List<PlayCallEntity> {
        return dao.loadAllPlayCall()
    }

    suspend fun savePlayCall(entity: PlayCallEntity) {
        dao.savePlayCall(entity)
    }
}