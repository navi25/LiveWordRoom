package io.navendra.livewordroom.model

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.migration.Migration

/**
 * Migration object for [WordRoomDatabase]
 */
object WordMigration{

    val MIGRATION_1_2: Migration = object : Migration(RoomConstants.currentVersion, RoomConstants.nextVersion) {
        override fun migrate(database: SupportSQLiteDatabase) {
            // Since we didn't alter the table, there's nothing else to do here.
        }
    }

}