package com.example.mobile_1_23227_ca1.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//Equivalent to database table
@Entity
class Cart_Entity(

    @PrimaryKey(autoGenerate = true)
    var cart_item_id : Int = 0,

    @ColumnInfo (name = "ITEM_NAME")
    var cart_item_name : String = "",

    @ColumnInfo (name = "ITEM_PRICE")
    var cart_item_price : Double = 0.0,

    @ColumnInfo (name = "ITEM_NUMBER")
    var cart_item_number : Int = 0
)