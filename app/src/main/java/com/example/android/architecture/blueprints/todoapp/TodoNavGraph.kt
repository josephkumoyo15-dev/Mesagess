package com.example.messages

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun ChatNavGraph(startDestination: String = "chat") {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination) {
        composable("chat") {
            ChatScreen() // your main chat screen
        }
    }
}