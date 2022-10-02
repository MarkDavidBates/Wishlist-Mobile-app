package org.setu.wishlist.console.controllers

import mu.KotlinLogging
import org.setu.wishlist.console.main.search
import org.setu.wishlist.console.models.WishlistMemStore
import org.setu.wishlist.console.models.WishlistModel
import org.setu.wishlist.console.views.WishlistView

class WishlistController {

    val wishlists = WishlistMemStore()
    val wishlistView = WishlistView()
    val logger = KotlinLogging.logger{}

    init {
        logger.info{"Launching Birthday Wishlist App"}
    }

    fun menu() : Int {return wishlistView.menu()}

    fun add(){

        val wishlist = WishlistModel()

        if(wishlistView.createWishlist(wishlist)){
            wishlists.create(wishlist)
        }
        else logger.info { "Not created! invalid additions" }
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
            else logger.info { "Wishlist not updated" }
        }
        else println("item not updated")
    }

    fun search(id: Long) : WishlistModel?{
        var foundWishlist: WishlistModel? = wishlists.findOne(id)
        return foundWishlist
    }
}