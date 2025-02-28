package com.example.a021125androidapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.a021125androidapp.ui.theme._021125AndroidAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _021125AndroidAppTheme() {
            Main()
            }
        }
    }
}

@Composable
fun Main(){
    UserListView()
}

@Composable
fun UserListView(vm: UserListViewModel = viewModel()){
    Column {
        UserData(
            vm.userLogin,
            vm.userPassword,
            changeLogin = {vm.changeLogin(it)},
            changePassword = {vm.changePassword(it)},
            add = {vm.addUser()}
        )
        UserList(users = vm.users, delete = {vm.deleteUser(it)})
    }
}

@Composable
fun UserData(login: String, password: String, changeLogin:(String)-> Unit,changePassword:(String)-> Unit, add:()->Unit){
    Column{
        OutlinedTextField(
            value = login,
            onValueChange = {changeLogin(it)},
            modifier = Modifier.padding(5.dp),
            label = { Text("Введите логин") }
        )
        OutlinedTextField(
            value = password,
            onValueChange = {changePassword(it)},
            modifier = Modifier.padding(5.dp),
            label = { Text("Введите пароль") }
        )

        Button(onClick = {add()}, Modifier.padding(5.dp)){
            Text("Создать", fontSize = 22.sp)
        }
    }
}

@Composable
fun UserList(users:List<User>, delete: (User) -> Unit){
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier =  Modifier.fillMaxWidth().padding(5.dp)
    ){
        Text("логин", fontSize = 28.sp, modifier = Modifier.weight(0.3f).padding(5.dp))
        Text("пароль", fontSize = 28.sp, modifier = Modifier.padding(10.dp))
        Text("удалить", fontSize = 28.sp, modifier = Modifier.weight(0.4f))
        }
    LazyColumn(Modifier.fillMaxSize()) {
        itemsIndexed(users){i, u->
            UserRow(u, delete, modifier = Modifier.background(if (i%2==0) Color.DarkGray else Color.Gray))
        }
    }
}

@Composable
fun UserRow(u: User, delete: (User) -> Unit, modifier: Modifier){
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth().padding(5.dp).then(modifier)
    ){
        Text(u.login, fontSize = 28.sp, modifier = Modifier.weight(0.3f).padding(5.dp))
        Text(u.password, fontSize = 28.sp, modifier = Modifier.weight(0.3f).padding(10.dp))
        TextButton(onClick = {delete(u)}, modifier = Modifier.weight(0.4f)) {
            Text("Удалить", fontSize = 28.sp)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    _021125AndroidAppTheme {
        Main()
    }
}