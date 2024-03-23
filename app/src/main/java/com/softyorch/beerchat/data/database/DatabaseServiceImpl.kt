package com.softyorch.beerchat.data.database

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.softyorch.beerchat.domain.interfaces.IDatabaseService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DatabaseServiceImpl @Inject constructor(private val context: Context) : IDatabaseService {

    companion object {
        private val USER_NAME = stringPreferencesKey("username")
    }

    private val Context.userPreferenceDataStore: DataStore<Preferences> by preferencesDataStore(
        name = "user"
    )

    override fun getUserName(): Flow<String> {
        return context.userPreferenceDataStore.data.map { preferences ->
            preferences[USER_NAME] ?: ""
        }
    }

    override suspend fun saveUserName(userName: String) {
        context.userPreferenceDataStore.edit { preference ->
            preference[USER_NAME] = userName
        }
    }

    override suspend fun clear() {
        context.userPreferenceDataStore.edit { preference ->
            preference[USER_NAME] = ""
        }
    }
}
