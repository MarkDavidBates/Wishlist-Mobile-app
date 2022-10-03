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
    logger.info { "Launching Birthday Wishlist App" }

    controller.start()

}

fun menu() : Int {

    var option : Int
    var input: String? = null

    println("Main Menu")
    println(" 1. Create New Wishlist")
    println(" 2. Update Existing Wishlist")
    println(" 3. Delete Wishlist")
    println(" 4. Show all Wishlists")
    println("-1. Exit")
    println()
    print("==> ")
    input = readLine()!!
    option = if (input.toIntOrNull() != null && !input.isEmpty())
        input.toInt()
    else
        -9
    return option
}

fun createWishlist(){

    val wishlist = WishlistModel()

    println("""===================================
        |=         CREATE WISHLIST         =
        |===================================""".trimMargin())

    if(wishlistView.createWishlist(wishlist)){
        wishlists.create(wishlist)
    }
    else logger.info { "Not created! invalid additions" }
}

fun updateWishlist(){

    var searchId = wishlistView.getId()
    val wishlist = search(searchId)

    println("""===================================
        |=         UPDATE WISHLIST         =
        |===================================""".trimMargin())

    if(wishlist != null){

        if (wishlistView.updateWishlist(wishlist)){
            wishlists.update(wishlist)
            logger.info("wishlist updated: $wishlist")
        }
        else logger.info { "Wishlist not updated" }
    }
    else println("item not updated")
}

fun deleteWishlist(){
    println("""===================================
        |=         DELETE WISHLIST         =
        |===================================""".trimMargin())

    var searchId = wishlistView.getId()

    println("wishlist ID: ")

}

fun search(id: Long) : WishlistModel? {
    var foundWishlist: WishlistModel? = wishlists.findOne(id)
    return foundWishlist
}