package com.makara.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.makara.data.MakaraRepository
import com.makara.data.local.pref.MakaraPreference
import com.makara.data.remote.retrofit.ApiConfig

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("token")
object Injection {
    fun provideRepository(context: Context): MakaraRepository {
        val pref = MakaraPreference.getInstance(context.dataStore)
        val apiService = ApiConfig.getApiService()
        return MakaraRepository(apiService, pref)
    }
}