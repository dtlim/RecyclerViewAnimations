package com.dtlim.recyclerviewanimations

/**
 * Created by dalelim on 11/20/17.
 */
data class FeedItem(var name: String, var username: String, var content: String, var time: String) {
    var profilePictureUrl: String = ""
    var imageUrl: String = ""
    var location: String = ""
    var starred: Boolean = false
}