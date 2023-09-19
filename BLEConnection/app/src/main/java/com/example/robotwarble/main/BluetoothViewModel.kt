package com.example.robotwarble.main

import android.bluetooth.BluetoothAdapter
import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BluetoothViewModel @Inject constructor(
    private val bluetoothAdapter: BluetoothAdapter
): ViewModel(){

    fun bluetoothAdaptertMsj(){
        Log.i("OnBluetoothAdapter", "Se lñlamo al bluetoothAdapter")
    }
}