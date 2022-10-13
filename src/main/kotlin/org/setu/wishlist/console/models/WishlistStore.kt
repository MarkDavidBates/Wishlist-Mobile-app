package org.setu.wishlist.console.models

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import mu.KotlinLogging

import org.setu.wishlist.console.helpers.*
import java.util.*



interface WishlistStore {
    fun findAll(): List<WishlistModel>
    fun findOne(id: Long): WishlistModel?
    fun create(wishlist: WishlistModel)
    fun update(wishlist: WishlistModel)

}