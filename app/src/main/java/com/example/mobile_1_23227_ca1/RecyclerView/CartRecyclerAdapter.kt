package com.example.mobile_1_23227_ca1.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile_1_23227_ca1.Database.Cart_Entity
import com.example.mobile_1_23227_ca1.R
import kotlinx.android.synthetic.main.layout_cart_list_item.view.*

class CartRecyclerAdapter(private val allCart: MutableList<Cart_Entity>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_cart_list_item, parent, false)
        return CartViewHolder(view)
    }

    override fun getItemCount(): Int = allCart.size
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //Binds database info to textviews in order to display them.
        holder.itemView.name.text = allCart[position].cart_item_name
        holder.itemView.price.text = allCart[position].cart_item_price.toString() + " €"
        if(allCart[position].cart_item_number == 1){
            holder.itemView.number.text = allCart[position].cart_item_number.toString() + " bag"
        } else {
            holder.itemView.number.text = allCart[position].cart_item_number.toString() + " bags"
        }
    }

    class CartViewHolder (view: View): RecyclerView.ViewHolder(view){}

}