package com.example.mobile_1_23227_ca1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile_1_23227_ca1.models.CartItem
import kotlinx.android.synthetic.main.layout_cart_list_item.view.*

class CartRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private  var items: MutableList<CartItem> = ArrayList()


    fun del(position: Int){
        items.removeAt(position)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CartViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.layout_cart_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is CartViewHolder -> {
                holder.bind(items[position])
            }
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(cartList: MutableList<CartItem>) {
        items = cartList
    }

    class CartViewHolder constructor(
            itemView: View
    ): RecyclerView.ViewHolder(itemView){
        val cartItemName = itemView.cart_item_name
        val cartItemPrice = itemView.cart_item_price
        val cartItemNumber = itemView.cart_item_number

        fun bind(cartItem: CartItem){
            cartItemName.text = cartItem.name
            cartItemPrice.text = cartItem.price.toString();
            cartItemNumber.text = cartItem.number.toString();
        }
    }
}