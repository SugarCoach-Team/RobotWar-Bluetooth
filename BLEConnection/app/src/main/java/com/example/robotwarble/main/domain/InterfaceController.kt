package com.example.robotwarble.main.domain

import android.bluetooth.BluetoothDevice
import kotlinx.coroutines.flow.StateFlow

interface InterfaceController {
    val scannedDevices: StateFlow<List<BluetoothDomain>>
    val pairedDevices: StateFlow<List<BluetoothDomain>>

    fun startDiscovery()
    fun stopDiscovery()

    fun release()
}