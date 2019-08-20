package br.com.tiagokamegasawa.roomwordsample

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import br.com.tiagokamegasawa.roomwordsample.dao.WordDao
import br.com.tiagokamegasawa.roomwordsample.dao.WordRoomDatabase
import br.com.tiagokamegasawa.roomwordsample.model.Word
import br.com.tiagokamegasawa.roomwordsample.repository.WordRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WordViewModel(application: Application,
                    val repository: WordRepository) : AndroidViewModel(application) {

    val allWords: LiveData<List<Word>> = repository.allWords

    fun insert(word: Word) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(word)
    }
}