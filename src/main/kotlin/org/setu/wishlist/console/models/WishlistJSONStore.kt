package org.setu.wishlist.console.models


import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import mu.KotlinLogging

import org.setu.wishlist.console.helpers.*
import java.util.*

private val logger = KotlinLogging.logger {}

val JSON_FILE = "placemarks.json"
val gsonBuilder = GsonBuilder().setPrettyPrinting().create()
val listType = object : TypeToken<java.util.ArrayList<WishlistModel>>() {}.type

fun generateRandomId(): Long {
    return Random().nextLong()
}


class WishlistJSONStore : WishlistStore {

    var wishlists = mutableListOf<WishlistModel>()

    init{
        if(exists(JSON_FILE)){
            deserialize()
        }
    }

    override fun findAll(): MutableList<WishlistModel> {
        return wishlists
    }

    override fun findOne(id: Long): WishlistModel? {
        var foundWishlist: WishlistModel? = wishlists.find { p -> p.id == id }
        return foundWishlist
    }

    override fun create(wishlist: WishlistModel) {
        wishlist.id = generateRandomId()
        wishlists.add(wishlist)
        serialize()
    }

    override fun update(wishlist: WishlistModel) {
        var foundWishlist = findOne(wishlist.id!!)
        if (foundWishlist != null) {
            foundWishlist.title = wishlist.title
            foundWishlist.description = wishlist.description
        }
        serialize()
    }

    internal fun logAll() {
        wishlists.forEach { logger.info("${it}") }
    }

    private fun serialize() {
        val jsonString = gsonBuilder.toJson(wishlists, listType)
        write(JSON_FILE, jsonString)
    }

    private fun deserialize() {
        val jsonString = read(JSON_FILE)
        wishlists = Gson().fromJson(jsonString, listType)
    }
}