package org.setu.wishlist.console.main

import mu.KotlinLogging
import org.setu.wishlist.console.controllers.WishlistController
import org.setu.wishlist.console.models.WishlistMemStore
import org.setu.wishlist.console.models.WishlistModel
import org.setu.wishlist.console.views.WishlistView

private val logger = KotlinLogging.logger {}

val wishlists = WishlistMemStore()
val wishlistView = WishlistView()
val controller = WishlistController()

//TODO: add a date to creation of new class
//TODO: change String to Array and Int

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
        | 1 | Create New Wishlist      | < |
        | 2 | Update Existing Wishlist | < |
        | 3 | Delete Existing Wishlist | < |
        | 4 | Show All Wishlists       | < |
        |-1 | Exit Application         | < |
    """.trimIndent())
    println()
    print("==> ")
    input = readLine()!!
    option = if (input.toIntOrNull() != null && !input.isEmpty())
        input.toInt()
    else
        -9
    return option
}

fun search(id: Long) : WishlistModel? {
    var foundWishlist: WishlistModel? = wishlists.findOne(id)
    return foundWishlist
}