package com.example.mobile_1_23227_ca1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_cart.*

class CartActivity : AppCompatActivity() {

    private lateinit var cartAdapter: CartRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
/*
        val cartInfo: String? = intent.getStringExtra("shared")
        val textview = findViewById<TextView>(R.id.CartInfo)
        //todoItems?.forEach{ currentTodoItem -> textview.text ="$currentTodoItem" }
        textview.text = cartInfo*/

        val item=object:SwipeToDelete(this,0,ItemTouchHelper.RIGHT){
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                cartAdapter.del(viewHolder.adapterPosition)
            }
        }

        val itemTouchHelper=ItemTouchHelper(item)
        itemTouchHelper.attachToRecyclerView(recycler_view)

        initRecyclerView()
        addDataSet()
    }

    private fun addDataSet(){
        val data = DataSource.createDataSet()
        cartAdapter.submitList(data)
    }

    private fun initRecyclerView() {
        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@CartActivity)
            cartAdapter = CartRecyclerAdapter()
            adapter = cartAdapter
        }
    }




}

