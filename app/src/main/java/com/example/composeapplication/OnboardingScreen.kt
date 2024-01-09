package com.example.composeapplication

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeapplication.ui.theme.Blue
import com.example.composeapplication.ui.theme.Chartreuse
import com.example.composeapplication.ui.theme.ComposeApplicationTheme
import com.example.composeapplication.ui.theme.LightBlue
import com.example.composeapplication.ui.theme.Navy

class OnboardingScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(this, MainActivity::class.java)
        setContent {
            ComposeApplicationTheme {
                Surface(
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "Welcome to My app,")
                        Text(text = "Using Jetpack Compose technology lho ~ ~")
                        Button(onClick = {
                            startActivity(intent)
                        }) {
                            Text(text = "Continue")
                        }
                    }
                }

            }
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark"
)

@Preview
@Composable
fun Prev() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = if (isSystemInDarkTheme()) Navy else Color.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                color = if (isSystemInDarkTheme()) Navy else Color.White,
                modifier = Modifier.padding(vertical = 4.dp)
            ) {
                Row(
                    modifier = Modifier
                        .padding(12.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Column(
                        modifier = Modifier
                            .background(color = Blue)
                            .padding(horizontal = 10.dp)
                            .width(300.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            modifier = Modifier.padding(top = 20.dp),
                            text = "Welcome to My app",
                            color = Color.White
                        )
                        ElevatedButton(
                            onClick = {},
                            modifier = Modifier
                                .padding(top = 20.dp, bottom = 20.dp)
                        ) {
                            Text(
                                text = "Continue"
                            )
                    }
                }
            }
        }

    }
}
