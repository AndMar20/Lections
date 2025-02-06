package com.example.a020525androidapp.ui.theme.screens

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a020525androidapp.R


@Composable
fun AuthorizationScreen(){
    val login = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize())
    {
        Text("Войти в IT", fontSize = 35.sp, modifier = Modifier.padding(30.dp))
        Column(verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.height(150.dp)) {
            TextField(
                value = login.value,
                onValueChange = { newValue -> login.value = newValue },
                label = { Text("Логин") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                textStyle = TextStyle(fontSize = 20.sp),
                modifier = Modifier.padding(vertical = 10.dp)
            )
            val passwordVisible = remember { mutableStateOf(false) }
            TextField(
                value = password.value,
                onValueChange = { newValue -> password.value = newValue },
                label = { Text("Пароль") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                visualTransformation =
                if (passwordVisible.value)
                    VisualTransformation.None
                else
                    PasswordVisualTransformation(),
                textStyle = TextStyle(fontSize = 20.sp),
                trailingIcon = {
                    val image =
                        if (passwordVisible.value)
                            ImageVector.vectorResource(R.drawable.baseline_visibility_off_24)
                        else
                            ImageVector.vectorResource(R.drawable.baseline_visibility_24)
                    IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                        Icon(imageVector = image, "")
                    }
                },
                modifier = Modifier.padding(vertical = 10.dp)
            )
        }
        Button(onClick = {

        }, modifier = Modifier.padding(30.dp)) {
            Text("Авторизоваться", fontSize = 28.sp)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun AuthorizationPreview(){
    AuthorizationScreen()
}