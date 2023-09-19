package com.example.robotwarble.main.di

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.content.Context
import androidx.core.content.getSystemService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideBluetoothAdapter(manager: BluetoothManager): BluetoothAdapter {
        return manager.adapter
    }

    @Provides
    @Singleton
    fun providesBluetoothManager(@ApplicationContext context: Context): BluetoothManager{
        return context.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
    }
}