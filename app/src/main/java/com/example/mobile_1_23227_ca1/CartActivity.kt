package com.example.mobile_1_23227_ca1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.mobile_1_23227_ca1.Database.AppDb
import com.example.mobile_1_23227_ca1.Database.Cart_Entity
import com.example.mobile_1_23227_ca1.RecyclerView.CartRecyclerAdapter
import kotlinx.android.synthetic.main.activity_cart.*

class CartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        val db = Room.databaseBuilder(
            this, AppDb::class.java, "CartDb"
        ).allowMainThreadQueries()
            .build()
        val allCart = db.cartDao().getAllCart()
        cartRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@CartActivity)
            adapter = CartRecyclerAdapter(allCart as MutableList<Cart_Entity>)

        }

        total.text = "Total : " + db.cartDao().getTotalPrice().toString() + " €"

        clear.setOnClickListener{
            db.cartDao().deleteAll()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        pay.setOnClickListener{
            db.cartDao().deleteAll()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    fun goBack(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}

