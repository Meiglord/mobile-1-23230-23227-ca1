package com.example.mobile_1_23227_ca1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import com.example.mobile_1_23227_ca1.models.CartItem
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDateTime

class DarjellingActivity : AppCompatActivity() {

    private lateinit var cartAdapter: CartRecyclerAdapter
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_darjelling)
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

    fun addToCart(view: View) {
        val price = count * 8.5
        //var sharedPreferences = getSharedPreferences(getString(R.string.PrefsPackage), Context.MODE_PRIVATE)
        //var todoItems = sharedPreferences.getStringSet(getString(R.string.ToDoItemStrings), setOf())?.toMutableSet()
        //var sampleToDoItem = count.toString() + getString(R.string.Darjelling) + price.toString()
        val intent = Intent(this, CartActivity::class.java)
        //todoItems?.add(sampleToDoItem)
        //sharedPreferences.edit().putStringSet(getString(R.string.ToDoItemStrings),todoItems).apply()
        //intent.putExtra("shared", "$todoItems")
        val data = DataSource.addData(getString(R.string.Darjelling),price,count)
        cartAdapter = CartRecyclerAdapter()
        cartAdapter.submitList(data)
        startActivity(intent)

    }
}