package com.example.robotwarble

import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.example.robotwarble.main.BluetoothViewModel
import com.example.robotwarble.main.MainScreen

class MainActivity : ComponentActivity() {
    var bluetoothAdapter: BluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel by viewModels<BluetoothViewModel>()
        setContent {
            MainScreen(viewModel)
        }
    }
    override fun onStart() {
        super.onStart()
        showDialog()
    }

    private val resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode != Activity.RESULT_OK) {
                Log.i("OnBluetooth", "El bluetooth esta apagado")
                showDialog()
            }
        }
    private fun showDialog(){
        if(!bluetoothAdapter.isEnabled){
            val enableBluetoothIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            resultLauncher.launch(enableBluetoothIntent)
        }
    }

}