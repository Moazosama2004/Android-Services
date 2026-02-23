package com.example.startedservice

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.startedservice.ui.theme.StartedServiceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StartedServiceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    StartServiceScreen(
                        context = this,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun StartServiceScreen(context: Context, modifier: Modifier = Modifier) {
    val intent = Intent(context, StartedService::class.java)
    var isActive by remember { mutableStateOf(false) }
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

        ) {
        Button(
            onClick = {
                if (!isActive) {
                    context.startService(intent)
                    isActive = !isActive
                }
            }
        ) {
            Text(
                text = "Start Started Service"
            )
        }


        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Button(
            onClick = {
                if (isActive) {
                    context.stopService(intent)
                    isActive = !isActive
                }

            }
        ) {
            Text(
                text = "Stop Started Service"
            )
        }

    }
}

