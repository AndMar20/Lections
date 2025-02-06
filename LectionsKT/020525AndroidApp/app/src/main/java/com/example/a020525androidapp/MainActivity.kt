package com.example.a020525androidapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Checkbox
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a020525androidapp.ui.theme._020525AndroidAppTheme
import com.example.a020525androidapp.ui.theme.screens.AuthorizationPreview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _020525AndroidAppTheme {
                Components()
            }
        }
    }
}

@Composable
fun SurfaceElement(){
    Surface (
        contentColor = Color.LightGray,
        color = Color.DarkGray,
        shadowElevation = 5.dp,
        modifier = Modifier
            .fillMaxSize()
    )
    {
        val range = (1..1000).toList()
        LazyVerticalGrid(
            columns = GridCells.Adaptive(70.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxSize()
        )
        {
            items(items = range){ item -> Text(text = "$item", fontSize = 28.sp)}
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FlowElement(){
    val langs = listOf("kotlin", "c#", "java", "python", "c++")
//помещаются в строчку до тех пока помещаются в строчку
    FlowRow(Modifier.fillMaxSize()) {
        langs.forEach{lang ->
            Text(text = "$lang",
                fontSize = 28.sp,
                    modifier = Modifier
                        .padding(10.dp)
                        .background(Color.Green)
            )

        }
    }
}

@Composable
fun NeedSize(){
    Column(Modifier.padding(5.dp).width(IntrinsicSize.Max)) {
        Text("Hello", fontSize = 29.sp, modifier = Modifier.padding(start = 4.dp))
        Box(Modifier.height(10.dp).fillMaxWidth().background(Color.Blue))
    }
}

@Composable
fun Components() {
    Column(Modifier.padding(30.dp).width(IntrinsicSize.Max)) {
        val checkedState = remember { mutableStateOf(true) }
        Checkbox(
            checked = checkedState.value,
            onCheckedChange = { checkedState.value = it }
        )

        val radioState = remember { mutableStateOf(true) }

        Column(Modifier.selectableGroup()) {
            RadioButton(
                selected = radioState.value,
                onClick = { radioState.value = true }
            )
            RadioButton(
                selected = !radioState.value,
                onClick = { radioState.value = false }
            )
        }

        val langs = listOf("kotlin", "c#", "java", "python", "c++")
        val (selectiedOption, onOptionSelected) = remember { mutableStateOf(langs[0]) }
        Text(text = selectiedOption)
        Column(Modifier.selectableGroup()) {
            langs.forEach { text ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = text == selectiedOption,
                        onClick = { onOptionSelected(text) }
                    )
                    Text(text)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    _020525AndroidAppTheme {
        Components()
    }
}