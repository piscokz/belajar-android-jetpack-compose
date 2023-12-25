package com.example.composeapplication

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuBoxScope
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapplication.ui.theme.ComposeApplicationTheme

@Composable
fun UiScreenKalkulator4() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter),
        ) {

        }
    }
}


@Composable
fun UiScreen() {
    var angka by remember {
        mutableIntStateOf(0)
    }
    Box(
        Modifier
            .fillMaxSize()
            .background(color = Color.White),
    ) {
        Column(
            Modifier
                .fillMaxSize(),
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.6f)
                    .background(Color.White),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = if (angka == 100) {
                        "${angka.toString()}!!"
                    } else {
                        angka.toString()
                    },
                    fontSize = if (angka < 100) {
                        angka.sp
                    } else {
                        100.sp
                    },
                    color = Color.Black,
                )
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.4f),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.Absolute.Center
            ) {
                Button(
                    onClick = {
                        if (angka < 100) {
                            angka++
                        }
                    },
                ) {
                    Text(
                        text = "click me!",
                    )
                }
            }
        }
    }
}

@Composable
fun Exp() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
    ) {
        Column(

            modifier = Modifier
                .background(Color.Green)
                .align(Alignment.BottomCenter)
        ) {
            Text(
                text = "asadassad",
            )
        }
    }

}

@Preview
@Composable
fun Pareview() {
    ComposeApplicationTheme {
        UiScreen()
    }
}