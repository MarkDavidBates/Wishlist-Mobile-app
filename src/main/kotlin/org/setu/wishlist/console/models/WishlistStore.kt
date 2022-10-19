package org.setu.wishlist.console.models

interface WishlistStore {
    fun findAll(): List<WishlistModel>
    fun findOne(id: Long): WishlistModel?
    fun create(wishlist: WishlistModel)
    fun update(wishlist: WishlistModel)
    fun delete(wishlist: WishlistModel)
}