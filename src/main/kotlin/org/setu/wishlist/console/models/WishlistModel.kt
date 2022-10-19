package org.setu.wishlist.console.models
import java.time.LocalDate;
import java.time.ZonedDateTime
import java.util.Date
import kotlin.collections.ArrayList

//TODO: add date

data class WishlistModel(var id: Long = 0,
                         var title: String = "",
                         var description: String = "",
                         var attendees: ArrayList<String> = ArrayList(),
                         var cost: Int = 0,
                         var date: String = ""
                         )