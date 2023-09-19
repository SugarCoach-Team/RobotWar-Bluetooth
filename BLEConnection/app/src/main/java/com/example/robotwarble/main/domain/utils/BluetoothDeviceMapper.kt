package com.example.robotwarble.main.domain.utils

import android.annotation.SuppressLint
import android.bluetooth.BluetoothDevice
import com.example.robotwarble.main.domain.BluetoothDomain

@SuppressLint("MissingPermission")
fun BluetoothDevice.toBluetoothDeviceDomain(): BluetoothDomain {
    return BluetoothDomain(
        name = name,
        address = address
    )
}