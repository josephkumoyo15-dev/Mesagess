package com.example.messages

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ChatScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Chat") }
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
            ) {
                var message by remember { mutableStateOf("") }

                TextField(
                    value = message,
                    onValueChange = { message = it },
                    placeholder = { Text("Type a message") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )

                Button(
                    onClick = { /* Handle send */ },
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(16.dp)
                ) {
                    Text("Send")
                }
            }
        }
    )
}