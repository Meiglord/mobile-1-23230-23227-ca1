package com.example.mobile_1_23227_ca1.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//Database init
@Database (entities = [(Cart_Entity::class)], version = 1, exportSchema = false)
abstract class AppDb : RoomDatabase() {
    abstract fun cartDao(): Cart_DAO
}