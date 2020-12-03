package com.example.mobile_1_23227_ca1.Database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface Cart_DAO {

    @Insert
    fun insertCart(cart: Cart_Entity)

    @Query("SELECT * FROM Cart_Entity")
    fun getAllCart() : List<Cart_Entity>

    @Query("DELETE FROM Cart_Entity")
    fun deleteAll()

    @Query("SELECT COALESCE(sum(COALESCE(ITEM_PRICE,0)), 0) From Cart_Entity")
    fun getTotalPrice() : Int

    @Query("SELECT COALESCE(sum(COALESCE(ITEM_NUMBER,0)), 0) From Cart_Entity")
    fun getTotalItems() : Int

    @Query("SELECT ITEM_NUMBER From Cart_Entity WHERE ITEM_NAME LIKE 'Delivery charge'")
    fun getDeliveryCharge() : Int
}