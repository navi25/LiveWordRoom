package io.navendra.livewordroom.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import io.navendra.livewordroom.model.Word
import android.arch.lifecycle.LiveData
import io.navendra.livewordroom.model.WordRepository


class WordViewModel(application: Application) : AndroidViewModel(application) {

    private val mRepository: WordRepository

    private val allWords: LiveData<List<Word>>

    init {
          mRepository = WordRepository(application)
          allWords = mRepository.getAllWords()
    }

    fun insert(word: Word) {
        mRepository.insert(word)
    }

    fun getAllWords() = allWords

}