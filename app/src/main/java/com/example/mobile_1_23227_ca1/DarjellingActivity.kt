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
import kotlinx.android.synthetic.main.activity_darjelling.*

class DarjellingActivity : AppCompatActivity() {

    //init counting of product bags we want to add to the cart
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_darjelling)


        //wait for the button "Add to cart" to be pressed
        addToCart.setOnClickListener{
            if(count > 0) {
                //Calculate the total price with the number of bags inputted
                var price = count * 8.5

                //Init database
                val db = Room.databaseBuilder(
                    this,AppDb :: class.java,"CartDb"
                ).allowMainThreadQueries()
                    .build()

                //Insert item in cart using the insertCart function in the Database/Cart_DAO file.
                db.cartDao().insertCart(Cart_Entity(cart_item_name = getString(R.string.Darjelling), cart_item_price=price, cart_item_number = count))

                //Calculate the total number of items in the bag using the totalItems function in the Database/Cart_DAO file.
                val totalItems = db.cartDao().getTotalItems()

                //Watch if the delivery charge is in the bag using the isDeliveryUp function in the Database/Cart_DAO file.
                val isDeliveryUp = db.cartDao().getDeliveryCharge()
                var deliveryPrice = 5.0

                //Watch if the delivery charge is in the bag and if there is more than 4 items, and add the delivery charge to the bag.
                if(totalItems > 4 && isDeliveryUp == 0){
                    db.cartDao().insertCart(Cart_Entity(cart_item_name = getString(R.string.DeliveryCharge), cart_item_price= deliveryPrice , cart_item_number = 1))
                }

                //Go to Cart Activity
                val intent = Intent(this, CartActivity::class.java)
                startActivity(intent)

            } else {

                //If the number of bags inputted while pressing "add to cart" is 0, ask to add bags
                Toast.makeText(this, "Please add bags before", Toast.LENGTH_LONG).show()
            }

        }
    }
    fun add(view: View) {
        //Add one bag and change the number on screen
        count++
        val textview = findViewById<TextView>(R.id.NumberCount)
        textview.text = "$count"
    }
    fun remove(view: View) {
        //Remove one bag and change the number on screen, but don't go under 0
        val textview = findViewById<TextView>(R.id.NumberCount)
        if (count > 0) {
            count--
            textview.text = "$count"
        }
    }
    fun goBack(view: View) {

        //Go back to main activity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
    }
}