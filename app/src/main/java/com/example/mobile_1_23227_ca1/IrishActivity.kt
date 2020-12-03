package com.example.mobile_1_23227_ca1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.room.Room
import com.example.mobile_1_23227_ca1.Database.AppDb
import com.example.mobile_1_23227_ca1.Database.Cart_Entity
import com.example.mobile_1_23227_ca1.RecyclerView.CartRecyclerAdapter
import kotlinx.android.synthetic.main.activity_irish.*

class IrishActivity : AppCompatActivity() {

    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_irish)

        addToCart.setOnClickListener{
            if(count > 0) {
                var price = count * 2.5
                val db = Room.databaseBuilder(
                    this,AppDb :: class.java,"CartDb"
                ).allowMainThreadQueries()
                    .build()
                db.cartDao().insertCart(Cart_Entity(cart_item_name = getString(R.string.Irish), cart_item_price=price, cart_item_number = count))
                val totalItems = db.cartDao().getTotalItems()
                val isDeliveryUp = db.cartDao().getDeliveryCharge()
                var deliveryPrice = 5.0
                if(totalItems > 4 && isDeliveryUp == 0){
                    db.cartDao().insertCart(Cart_Entity(cart_item_name = getString(R.string.DeliveryCharge), cart_item_price= deliveryPrice , cart_item_number = 1))
                }
                val intent = Intent(this, CartActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please add bags before", Toast.LENGTH_LONG).show()
            }

        }
    }
    fun add(view: View) {
        count++
        val textview = findViewById<TextView>(R.id.NumberCount)
        textview.text = "$count"
    }
    fun remove(view: View) {
        val textview = findViewById<TextView>(R.id.NumberCount)
        if (count > 0) {
            count--
            textview.text = "$count"
        }
    }
    fun goBack(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}