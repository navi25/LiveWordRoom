package io.navendra.livewordroom.model

object RoomConstants{

    //Tables and Columns
    const val WORD_DATABASE = "word_db"
    const val WORD_TABLE = "word_table"
    const val WORD_COLUMN = "word"

    //Queries
    const val DELETE_WORD_TABLE = "DELETE from $WORD_TABLE"
    const val GET_ALL_WORDS = "SELECT * from $WORD_TABLE ORDER BY $WORD_COLUMN ASC"

    //Migrations
    const val currentVersion = 1
    const val nextVersion = 2
}