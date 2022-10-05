package org.setu.wishlist.console.views

import org.setu.wishlist.console.models.WishlistMemStore
import org.setu.wishlist.console.models.WishlistModel

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

    fun listWishlists(wishlists: WishlistMemStore){
        println("""===================================
        |=       LIST ALL WISHLISTS        =
        |===================================""".trimMargin())

        org.setu.wishlist.console.main.wishlists.logAll()
    }

    fun createWishlist(wishlist: WishlistModel): Boolean {

        var tempAttendees: String?
        var array = ArrayList<String>()
        var arraySize: Int?
        var i = 0

        println("title: ")
        wishlist.title = readLine()!!
        println("description: ")
        wishlist.description = readLine()!!
        println("number of attendees: ")

        arraySize = readLine()!!.toInt()
        do {
            println("name: ")
            tempAttendees = readLine()!!
            array.add(tempAttendees)
            i++
        } while(i < arraySize)

        for(x in array){
            println(x)
        }

        println("ARRAY TEST OVER")
        println("attendees: ")
        wishlist.attendees = readLine()!!
        println("estimated cost: ")
        wishlist.cost = readLine()!!.toInt()

        return wishlist.title.isNotEmpty() && wishlist.description.isNotEmpty() && wishlist.attendees.isNotEmpty() && wishlist.cost > 0
    }

    fun updateWishlist(wishlist: WishlistModel) : Boolean {
        val temptitle: String?
        val tempdescription: String?
        val tempattendees: String?
        val tempcost: String?

        if(wishlist != null) {
            println("title: ")
            temptitle = readLine()!!
            println("description: ")
            tempdescription = readLine()!!
            println("attendees: ")
            tempattendees = readLine()!!
            println("estimated cost: ")
            tempcost = readLine()!!

            if (!temptitle.isNullOrEmpty() && !tempdescription.isNullOrEmpty() && !tempattendees.isNullOrEmpty() && !tempcost.isNullOrEmpty()) {



                wishlist.title = temptitle
                wishlist.description = tempdescription
                wishlist.attendees = tempattendees
                wishlist.cost = tempcost.toInt()
                return true
            }
        }
        return false
    }

    fun getId() : Long {
        var strId : String? // String to hold user input
        var searchId : Long // Long to hold converted id
        print("Enter id to Search/Update : ")
        strId = readLine()!!
        searchId = if (strId.toLongOrNull() != null && !strId.isEmpty())
            strId.toLong()
        else
            -9
        return searchId
    }
}