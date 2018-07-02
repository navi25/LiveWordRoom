package io.navendra.livewordroom.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull
import io.navendra.livewordroom.model.RoomConstants.WORD_COLUMN
import io.navendra.livewordroom.model.RoomConstants.WORD_TABLE

@Entity(tableName = WORD_TABLE)
data class Word(
        @PrimaryKey
        @NonNull
        @ColumnInfo(name = WORD_COLUMN)
        var mWord: String
)

