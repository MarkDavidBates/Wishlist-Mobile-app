package org.setu.wishlist.console.models

import mu.KotlinLogging

private val logger = KotlinLogging.logger {}
var lastId = 0L

internal fun getId(): Long {
    return lastId++
}

class WishlistMemStore: WishlistStore {

    val wishlists = ArrayList<WishlistModel>()

    override fun findAll(): List<WishlistModel> {
        return wishlists
    }

    override fun findOne(id: Long) : WishlistModel? {
        var foundWishlist: WishlistModel? = wishlists.find { p -> p.id == id }
        return foundWishlist
    }

    override fun create(wishlist: WishlistModel) {
        wishlist.id = getId()
        wishlists.add(wishlist)
        logAll()
    }

    override fun update(wishlist: WishlistModel) {
        var foundWishlist = findOne(wishlist.id!!)
        if (foundWishlist != null) {
            foundWishlist.title = wishlist.title
            foundWishlist.description = wishlist.description
            foundWishlist.attendees = wishlist.attendees
            foundWishlist.cost = wishlist.cost
        }
    }

    override fun delete(wishlist: WishlistModel) {
        TODO("Not yet implemented")
    }

    internal fun logAll() {
        wishlists.forEach { logger.info("${it}") }
    }
}