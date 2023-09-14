package com.example.robotwarble

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.robotwarble.presentation.Navigation
import com.example.robotwarble.ui.theme.RobotWarBLETheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RobotWarBLETheme {
                Navigation(

                )
            }
        }
    }
}