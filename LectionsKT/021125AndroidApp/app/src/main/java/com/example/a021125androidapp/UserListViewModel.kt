package com.example.a021125androidapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

data class User(val login:String, val password:String)
class UserListViewModel : ViewModel(){
    val users = mutableStateListOf<User>(User("admin", "admin"))

    var userLogin by mutableStateOf("")
    var userPassword by mutableStateOf("")

    fun addUser(){
        users.add(User(userLogin,userPassword))
    }

    fun changeLogin(value:String){
        userLogin = value
    }
    fun changePassword(value:String){
        userPassword = value
    }

    fun deleteUser(user: User){
        users.remove(user)
    }

}