package com.example.messages

import androidx.navigation.NavController

/**
 * Simple navigation actions for Chat simulator
 */
class ChatNavigationActions(private val navController: NavController) {
    fun navigateToChat() {
        navController.navigate("chat")
    }
}