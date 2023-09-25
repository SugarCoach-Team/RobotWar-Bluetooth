package com.example.robotwarble.main

import android.bluetooth.BluetoothAdapter
import android.util.Log
import androidx.compose.runtime.Composable
import com.example.robotwarble.main.permission.SystemBroadcastReceiver

@Composable
fun MainScreen (
    onBluetoothStateChanged:()->Unit
) {
    SystemBroadcastReceiver(systemAction = BluetoothAdapter.ACTION_STATE_CHANGED){ bluetoothState ->
        val action = bluetoothState?.action ?: return@SystemBroadcastReceiver
        if(action == BluetoothAdapter.ACTION_STATE_CHANGED){
        }
        Log.i("OnBroadcast", "El broadcast se ejecuta")
        onBluetoothStateChanged()
    }
}