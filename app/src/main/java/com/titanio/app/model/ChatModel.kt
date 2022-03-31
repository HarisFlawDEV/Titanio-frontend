package com.titanio.app.model

data class ChatModel(
    val icon: Int,
    val name: String,
    val message: String,
    val duration: String,
    val tvMessageCount: String,
    val isText: Boolean,
    val isPhoto: Boolean,
    val isVideo: Boolean,

)