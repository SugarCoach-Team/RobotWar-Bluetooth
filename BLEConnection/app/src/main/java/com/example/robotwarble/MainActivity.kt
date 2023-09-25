package com.example.robotwarble

import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import com.example.robotwarble.main.MainScreen
import com.example.robotwarble.ui.theme.RobotWarBLETheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject lateinit var bluetoothAdapter: BluetoothAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val viewModel by viewModels<BluetoothViewModel>()
        setContent {
            RobotWarBLETheme {
                MainScreen (
                    onBluetoothStateChanged = { showDialog() }
                )
            }
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
        Log.i("OnDialog", "Se muestra el dialogo")
        if(!bluetoothAdapter.isEnabled){
            val enableBluetoothIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            resultLauncher.launch(enableBluetoothIntent)
        }
    }
}