package org.setu.wishlist.console.models

data class WishlistModel(var id: Long = 0,
                         var title: String = "",
                         var description: String = "",
                         //var attendees: String = "",
                         var attendees: ArrayList<String> = ArrayList(),
                         var cost: Int = 0){


}