package org.setu.wishlist.console.controllers

import mu.KotlinLogging
import org.setu.wishlist.console.models.WishlistJSONStore
import org.setu.wishlist.console.models.WishlistModel
import org.setu.wishlist.console.views.WishlistView


class WishlistController {

    val wishlists = WishlistJSONStore()
    val wishlistView = WishlistView()
    val logger = KotlinLogging.logger{}


    init {
        logger.info{"Launching Birthday Wishlist App"}
    }

    fun menu() : Int {return wishlistView.menu()}

    fun start(){

        var input: Int
        do {
            input = org.setu.wishlist.console.main.menu()
            when(input){
                1 -> add()
                2 -> update()
                3 -> delete()
                4 -> list()
                -1 -> println("| > |   EXITING, GOODBYE :)    | < |")
                else -> println("| > |         invalid!         | < |")
            }
            println()
        } while(input != -1)
        logger.info { "Shutting Down" }
    }

    fun add(){

        val wishlist = WishlistModel()

        if(wishlistView.createWishlist(wishlist)){
            wishlists.create(wishlist)
        }
        else logger.info { "| > |Not created! invalid additions| < |" }
    }

    fun list(){
        wishlistView.listWishlists(wishlists)
    }

    fun update(){

        var searchId = org.setu.wishlist.console.main.wishlistView.getId()
        val wishlist = search(searchId)

        if(wishlist != null){

            if (wishlistView.updateWishlist(wishlist)){
                wishlists.update(wishlist)
                logger.info("wishlist updated: $wishlist")
            }
        }
        else println("| > |  Wishlist not updated!   | < |")
    }

    fun search(id: Long) : WishlistModel?{
        var foundWishlist: WishlistModel? = wishlists.findOne(id)
        return foundWishlist
    }

    fun delete() {
        wishlistView.listWishlists(wishlists)
        var searchId = wishlistView.getId()
        val aWishlist = search(searchId)

        if(aWishlist != null) {
            wishlists.delete(aWishlist)
            println("| > |    Wishlist Deleted!     | < |")
            wishlistView.listWishlists(wishlists)
        }
        else
            println("| > |  Wishlist Not Deleted!   | < |")
    }
}