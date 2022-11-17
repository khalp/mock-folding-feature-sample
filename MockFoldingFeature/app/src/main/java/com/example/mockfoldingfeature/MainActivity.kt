package com.example.mockfoldingfeature

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import com.example.mockfoldingfeature.ui.theme.MockFoldingFeatureTheme
import com.microsoft.device.dualscreen.twopanelayout.TwoPaneLayout

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MockFoldingFeatureTheme {
                TwoPaneLayout(
                    pane1 = { Text("pane1") },
                    pane2 = { Text("pane2") }
                )
            }
        }
    }
}