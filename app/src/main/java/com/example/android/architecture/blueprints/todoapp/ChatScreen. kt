package com.example.messages

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class ChatMessage(
    val text: String,
    val fromMe: Boolean
)

@Composable
fun ChatScreen() {
    var canReply by remember { mutableStateOf(true) }
    var input by remember { mutableStateOf("") }

    val messages = remember {
        mutableStateListOf<ChatMessage>()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        // Top bar (simulated 3-dot control)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Chat", style = MaterialTheme.typography.titleLarge)
            Switch(
                checked = canReply,
                onCheckedChange = { canReply = it }
            )
        }

        if (!canReply) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Can't reply to short code",
                color = MaterialTheme.colorScheme.error
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Messages
        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(messages) { msg ->
                Text(
                    text = if (msg.fromMe) "Me: ${msg.text}" else "Sender: ${msg.text}",
                    modifier = Modifier.padding(4.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Input
        OutlinedTextField(
            value = input,
            onValueChange = { input = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Type or inject message") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row {
            Button(
                onClick = {
                    if (canReply && input.isNotBlank()) {
                        messages.add(ChatMessage(input, true))
                        input = ""
                    }
                },
                enabled = canReply
            ) {
                Text("Send")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = {
                    if (input.isNotBlank()) {
                        messages.add(ChatMessage(input, false))
                        input = ""
                    }
                }
            ) {
                Text("Inject")
            }
        }
    }
}