package org.setu.wishlist.console.views

class WishlistView {

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
}