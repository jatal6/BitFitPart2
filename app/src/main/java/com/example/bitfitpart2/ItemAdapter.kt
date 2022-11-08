package com.example.bitfitpart2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ItemAdapter(
    private val context: Context,
    private val bev: MutableList<ItemEntity>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.vol_fragment, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val foodEntity = bev[position]
        holder.bind(foodEntity)
    }

    override fun getItemCount() : Int{
        return bev.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val bevNameView = itemView.findViewById<TextView>(R.id.bev_name)
        private val bevVolumeView = itemView.findViewById<TextView>(R.id.bev_vol)

        fun bind(foodItem: ItemEntity) {
            bevNameView.text = foodItem.foodName
            bevVolumeView.text = foodItem.foodCalories
        }
    }
}