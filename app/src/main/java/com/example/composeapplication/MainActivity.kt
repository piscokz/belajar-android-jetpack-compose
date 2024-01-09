package com.example.composeapplication

import android.content.res.Configuration
import android.graphics.Paint.Style
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeapplication.ui.theme.ComposeApplicationTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeApplicationTheme {
                Surface {
                    MyApp(modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}

@Composable
private fun MyApp(
    modifier: Modifier = Modifier,
    names: List<String> = listOf("Fariyd", "Baim", "Seno")
) {
    Column(
        modifier = modifier
            .background(color = if (isSystemInDarkTheme() ) Color.Black else Color.White ),
    ) {
        for (name: String in names) {
            Greeting(nama = name)
        }
    }
}

@Composable
fun Greeting(nama: String) {
    var buttonSensor by rememberSaveable { mutableStateOf(false) }
    val smooth by animateDpAsState(
        targetValue = if(buttonSensor) 50.dp else 0.dp, label = "Animasi sang Dp",
        animationSpec = spring (
            Spring.DampingRatioMediumBouncy,
            Spring.StiffnessLow
        )
    )
        Surface(
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(24.dp)
                    .padding(bottom = if (buttonSensor) 24.dp else 0.dp)
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(bottom = smooth.coerceAtLeast(0.dp))
                ) {
                    Text(text = "Hello,")
                    Text(
                        text = nama,
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.ExtraBold,
                        )
                }
                ElevatedButton(
                    onClick = {
                        buttonSensor = !buttonSensor
                    },
                ) {
                    Text(
                        text = if (buttonSensor) {
                            "Show less"
                        } else {
                            "Show more"
                        },
                        color = Color.White
                    )
                }
            }
        }
    }

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark"
)

@Preview(showBackground = true, name = "tampilan UI")
@Composable
fun UI_Preview() {
    ComposeApplicationTheme {
            MyApp(Modifier.fillMaxSize(1f))
    }
}