package com.example.calculator.DI

import android.app.Application
import com.example.calculator.HistoryScreen.domain.HistoryViewModel
import com.example.calculator.HomeScreen.Room.Repository.HistoryRepository
import com.example.calculator.HomeScreen.Room.Repository.HistoryRepositoryImpl
import com.example.calculator.HomeScreen.Room.data_socurces.HistorySources
import com.example.calculator.HomeScreen.Room.data_socurces.RoomDataSources
import com.example.calculator.HomeScreen.Room.database.HistoryDataBase
import com.example.calculator.HomeScreen.domain.NumberViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(appModule)
        }
    }
}

val appModule = module{
    single {
        HistoryDataBase.getDatabase(androidContext())
    }
    single {
        get<HistoryDataBase>().HistoryDao()
    }
    single<HistorySources> {
        RoomDataSources(get())
    }
    single<HistoryRepository> {
        HistoryRepositoryImpl(get())
    }

    viewModel {
        NumberViewModel(get())
    }
    viewModel{
        HistoryViewModel(get())
    }

}
