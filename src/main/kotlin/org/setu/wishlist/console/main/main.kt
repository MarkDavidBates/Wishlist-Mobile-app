package org.setu.wishlist.console.main

import mu.KotlinLogging
import org.setu.wishlist.console.models.WishlistModel

private val logger = KotlinLogging.logger {}
val wishlist = WishlistModel()


fun main(args: Array<String>){
    logger.info { "Launching Birthday Wishlist App" }

    var input: Int
    do {
        input = menu()
        when(input){
            1 -> createWishlist()
            2 -> updateWishlist()
            3 -> deleteWishlist()
            4 -> listWishlists()
            -1 -> println("exiting, goodbye!")
        }
        println()
    } while(input != -1)
    logger.info { "Shutting Down" }

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
    println("""===================================
        |=         CREATE WISHLIST         =
        |===================================""".trimMargin())

    println("title: ")
    wishlist.title = readLine()!!
    println("description: ")
    wishlist.description = readLine()!!
    println("attendees: ")
    wishlist.attendees = readLine()!!
    println("estimated cost: ")
    wishlist.cost = readLine()!!

    println("""===================================
        |= TITLE: ${wishlist.title}                   
        |= DESCRIPTION: ${wishlist.description}       
        |= ATTENDEES: ${wishlist.attendees}           
        |= COST: ${wishlist.cost}                     
        |===================================""".trimMargin())
}

fun updateWishlist(){
    println("""===================================
        |=         UPDATE WISHLIST         =
        |===================================""".trimMargin())

    println("title: ")
    wishlist.title = readLine()!!
    println("description: ")
    wishlist.description = readLine()!!
    println("attendees: ")
    wishlist.attendees = readLine()!!
    println("estimated cost: ")
    wishlist.cost = readLine()!!

    println("""===================================
        |= TITLE: ${wishlist.title}                   
        |= DESCRIPTION: ${wishlist.description}       
        |= ATTENDEES: ${wishlist.attendees}           
        |= COST: ${wishlist.cost}                     
        |===================================""".trimMargin())

}

fun deleteWishlist(){
    println("""===================================
        |=         DELETE WISHLIST         =
        |===================================""".trimMargin())

}

fun listWishlists(){
    println("""===================================
        |=       LIST ALL WISHLISTS        =
        |===================================""".trimMargin())

}