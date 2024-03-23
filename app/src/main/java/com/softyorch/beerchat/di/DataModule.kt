package com.softyorch.beerchat.di

import android.content.Context
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.softyorch.beerchat.data.database.DatabaseServiceImpl
import com.softyorch.beerchat.data.network.FirebaseChatService
import com.softyorch.beerchat.domain.interfaces.IDatabaseService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun providesApplicationContext(@ApplicationContext context: Context): Context = context

    @Singleton
    @Provides
    fun providesDatabaseReference(): DatabaseReference = Firebase.database.reference

    @Singleton
    @Provides
    fun providesFirebaseService(reference: DatabaseReference) = FirebaseChatService(reference)

    @Singleton
    @Provides
    fun providesIDatabase(@ApplicationContext context: Context): IDatabaseService =
        DatabaseServiceImpl(context)

    @Provides
    fun providesDispatcherIO(): CoroutineDispatcher = Dispatchers.IO

}