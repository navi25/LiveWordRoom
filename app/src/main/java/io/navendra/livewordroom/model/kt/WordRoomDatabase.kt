package io.navendra.livewordroom.model.kt

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import io.navendra.livewordroom.model.RoomConstants.WORD_DATABASE
import io.navendra.livewordroom.model.Word
import io.navendra.livewordroom.model.WordDAO
import io.navendra.livewordroom.model.WordMigration


@Database(entities = [Word::class], version = 1)
abstract class WordRoomDatabaseKT(context: Context) : RoomDatabase() {

    abstract fun wordDao(): WordDAO

    companion object {

        private var INSTANCE: WordRoomDatabaseKT? = null

        internal fun getDatabase(context: Context): WordRoomDatabaseKT {
            if (INSTANCE == null) {
                synchronized(WordRoomDatabaseKT::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.applicationContext,
                                WordRoomDatabaseKT::class.java, WORD_DATABASE)
                                .addMigrations(WordMigration.MIGRATION_1_2)
                                .build()
                    }
                }
            }
            return INSTANCE!!
        }

    }

}