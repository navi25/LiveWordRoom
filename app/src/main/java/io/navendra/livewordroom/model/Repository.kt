package io.navendra.livewordroom.model

import android.app.Application
import android.arch.lifecycle.LiveData
import android.os.AsyncTask


class WordRepository internal constructor(application: Application) {

    private val mWordDao: WordDAO
    private val allWords: LiveData<List<Word>>

    init {
        val db = WordRoomDatabase.getDatabase(application)
        mWordDao = db.wordDao()
        allWords = mWordDao.getAllWords()
    }

    fun insert(word: Word) {
        InsertAsyncTask(mWordDao).execute(word)
    }

    private class InsertAsyncTask internal constructor(private val mAsyncTaskDao: WordDAO) : AsyncTask<Word, Void, Void>() {

        override fun doInBackground(vararg params: Word): Void? {
            mAsyncTaskDao.insert(params[0])
            return null
        }
    }
}
