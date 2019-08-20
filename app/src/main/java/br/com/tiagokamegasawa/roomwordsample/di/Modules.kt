package br.com.tiagokamegasawa.roomwordsample.di

import androidx.room.Room
import br.com.tiagokamegasawa.roomwordsample.WordViewModel
import br.com.tiagokamegasawa.roomwordsample.adapter.WordListAdapter
import br.com.tiagokamegasawa.roomwordsample.dao.WordRoomDatabase
import br.com.tiagokamegasawa.roomwordsample.repository.WordRepository
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dbModule = module {
    single {
        Room.databaseBuilder(
            get(),
            WordRoomDatabase::class.java,
            "Word_database"
        ).build()
    }

    single { get<WordRoomDatabase>().wordDao() }

    single { WordRepository(get()) }
}

val uiModule = module {
    factory {
        WordListAdapter(get())
    }
}

val viewModelModule = module {
    viewModel { WordViewModel(get(), get()) }
}