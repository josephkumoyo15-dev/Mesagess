package com.example.messages

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

sealed class Screen(val route: String) {
    object Chat : Screen("chat")
    object TodoList : Screen("todoList")
}

@Composable
fun TodoNavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = Screen.TodoList.route) {
        composable(Screen.TodoList.route) {
            TodoListScreen(navController)
        }
        composable(Screen.Chat.route) {
            ChatScreen()
        }
    }
}