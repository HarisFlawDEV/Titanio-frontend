package com.titanio.app.model

data class HomeModel(
    var image: Int,
    var title: String,
    var profilePic: Int,
    var userName: String,
    var timeAgo: String,
    var isVideo: Boolean,
    var isLike: Boolean
)