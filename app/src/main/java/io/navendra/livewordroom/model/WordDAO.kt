package io.navendra.livewordroom.model

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.navendra.livewordroom.model.RoomConstants.DELETE_WORD_TABLE
import io.navendra.livewordroom.model.RoomConstants.GET_ALL_WORDS

@Dao
interface WordDAO{

    @Insert(onConflict = OnConflictStrategy.REPLACE) //default room onConflict behaviour is ABORT
    fun insert(word: Word)

    @Query(DELETE_WORD_TABLE)
    fun deleteAll()

    @Query(GET_ALL_WORDS)
    fun getAllWords() : LiveData<List<Word>>
}