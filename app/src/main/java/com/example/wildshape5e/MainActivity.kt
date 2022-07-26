package com.example.wildshape5e

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.wildshape5e.beastlist.NavGraphs
import com.example.wildshape5e.ui.theme.WildShape5eTheme
import com.ramcosta.composedestinations.DestinationsNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WildShape5eTheme {
                DestinationsNavHost(navGraph = NavGraphs.root)

            }
        }
    }
}
