package com.example.mobile_1_23227_ca1

import com.example.mobile_1_23227_ca1.models.CartItem

class DataSource{

    companion object{

        fun createDataSet(): ArrayList<CartItem>{
            val list = ArrayList<CartItem>()
            list.add(
                    CartItem(
                            "Darjelling",
                            25.5,
                            9
                    )
            )
            return list
        }

        fun addData(name: String, price: Double, number: Int): ArrayList<CartItem>{
            val list = ArrayList<CartItem>()
            list.add(
                    CartItem(
                            name,
                            price,
                            number
                    )
            )
            return list
        }
    }
}