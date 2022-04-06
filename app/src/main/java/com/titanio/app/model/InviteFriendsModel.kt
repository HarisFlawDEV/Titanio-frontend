package com.titanio.app.model

class InviteFriendsModel {
    var friendName: String = ""
    var friendImage: Int = 0
    var isInviteSent: Boolean = false

    constructor(friendName: String, friendImage: Int, isInviteSent: Boolean) {
        this.friendName = friendName
        this.friendImage = friendImage
        this.isInviteSent = isInviteSent
    }

}