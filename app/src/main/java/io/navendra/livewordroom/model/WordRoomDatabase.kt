package io.navendra.livewordroom.model

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import io.navendra.livewordroom.model.RoomConstants.WORD_DATABASE


@Database(entities = [Word::class], version = 1)
abstract class WordRoomDatabase(context: Context) : RoomDatabase() {

    abstract fun wordDao(): WordDAO

    companion object {

        private var INSTANCE: WordRoomDatabase? = null

        internal fun getDatabase(context: Context): WordRoomDatabase {
            if (INSTANCE == null) {
                synchronized(WordRoomDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.applicationContext,
                                WordRoomDatabase::class.java, WORD_DATABASE)
                                .addMigrations(WordMigration.MIGRATION_1_2)
                                .build()
                    }
                }
            }
            return INSTANCE!!
        }

    }

}