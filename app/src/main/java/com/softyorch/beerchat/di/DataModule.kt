package com.softyorch.beerchat.di

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.softyorch.beerchat.data.network.FirebaseChatService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun providesDatabaseReference(): DatabaseReference = Firebase.database.reference

    @Singleton
    @Provides
    fun providesFirebaseService(reference: DatabaseReference) = FirebaseChatService(reference)

}