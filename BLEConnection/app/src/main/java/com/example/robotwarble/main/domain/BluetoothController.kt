package com.example.robotwarble.main.domain

import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.content.Context
import android.content.pm.PackageManager
import com.example.robotwarble.main.domain.utils.toBluetoothDeviceDomain
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@AndroidEntryPoint
@SuppressLint("MissingPermission")
class BluetoothController(
    private val context: Context
):InterfaceController {

    @Inject lateinit var bluetoothAdapter: BluetoothAdapter

    private val _scannedDevices = MutableStateFlow<List<BluetoothDomain>>(emptyList())
    override val scannedDevices: StateFlow<List<BluetoothDomain>>
        get() = _scannedDevices.asStateFlow()

    private val _pairedDevices = MutableStateFlow<List<BluetoothDomain>>(emptyList())
    override val pairedDevices: StateFlow<List<BluetoothDomain>>
        get() = _pairedDevices.asStateFlow()

    init{
        updatePairedDevices()
    }

    override fun startDiscovery() {
        TODO("Not yet implemented")
    }

    override fun stopDiscovery() {
        TODO("Not yet implemented")
    }

    override fun release() {
        TODO("Not yet implemented")
    }

    private fun updatePairedDevices(){
        if(!hasPermission(android.Manifest.permission.BLUETOOTH_CONNECT)){
            return
        }
        bluetoothAdapter
            .bondedDevices
            .map { it.toBluetoothDeviceDomain() }
            .also {devices ->
                _pairedDevices.update { devices }
            }
    }

    private fun hasPermission(permission: String): Boolean{
        return context.checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED
    }
}