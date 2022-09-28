package org.setu.wishlist.console.main

import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

fun main(args: Array<String>){
    logger.info { "Launching Birthday Wishlist App" }

    var input: Int
    do {
        input = menu()
        when(input){
            1 -> createWishlist()
            2 -> updateWishlist()
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
    option = input.toInt()

    return option
}

fun createWishlist(){
    println("""===================================
        |=         CREATE WISHLIST         =
        |===================================""".trimMargin())

    var title: String
    var description: String
    var attendees: String
    var cost: Int

    println("title: ")
    title = readLine()!!
    println("description: ")
    description = readLine()!!
    println("attendees: ")
    attendees = readLine()!!
    println("estimated cost: ")
    cost = readLine()!!.toInt()
}

fun updateWishlist(){
    println("""===================================
        |=         UPDATE WISHLIST         =
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