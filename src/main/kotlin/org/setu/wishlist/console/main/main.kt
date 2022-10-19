package org.setu.wishlist.console.main

import mu.KotlinLogging
import org.setu.wishlist.console.controllers.WishlistController
import org.setu.wishlist.console.models.WishlistMemStore
import org.setu.wishlist.console.models.WishlistModel
import org.setu.wishlist.console.views.WishlistView
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

private val logger = KotlinLogging.logger {}

val wishlists = WishlistMemStore()
val wishlistView = WishlistView()
val controller = WishlistController()

//TODO: clean up code and add validation

fun main(args: Array<String>){

    controller.start()

}

fun menu() : Int {

    var option : Int
    var input: String? = null

    println("""
___       __   ___  ________  ___  ___  ___       ___  ________  _________   
|\  \     |\  \|\  \|\   ____\|\  \|\  \|\  \     |\  \|\   ____\|\___   ___\ 
\ \  \    \ \  \ \  \ \  \___|\ \  \\\  \ \  \    \ \  \ \  \___|\|___ \  \_| 
 \ \  \  __\ \  \ \  \ \_____  \ \   __  \ \  \    \ \  \ \_____  \   \ \  \  
  \ \  \|\__\_\  \ \  \|____|\  \ \  \ \  \ \  \____\ \  \|____|\  \   \ \  \ 
   \ \____________\ \__\____\_\  \ \__\ \__\ \_______\ \__\____\_\  \   \ \__\
    \|____________|\|__|\_________\|__|\|__|\|_______|\|__|\_________\   \|__|
                       \|_________|                       \|_________|        
                                                                              
                                                                              
    """.trimIndent())
    println("""
        | 1 | Create New Wishlist      | < |    | 3 | Delete Existing Wishlist | < |
        | 2 | Update Existing Wishlist | < |    | 4 | Show All Wishlists       | < |
        
        
        |-1 | Exit Application         | < |
    """.trimIndent())
    println()
    print("| > | ==> ")
    input = readLine()!!
    option = if (input.toIntOrNull() != null && !input.isEmpty())
        input.toInt()
    else
        -9
    return option
}