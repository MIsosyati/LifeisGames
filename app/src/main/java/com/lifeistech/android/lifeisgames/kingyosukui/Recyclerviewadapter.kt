package com.lifeistech.android.lifeisgames.kingyosukui

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lifeistech.android.lifeisgames.R

class Recyclerviewadapter(private val context:Context):RecyclerView.Adapter<Recyclerviewadapter.Viewholder>() {
    val items:MutableList<Fish_library_data> = mutableListOf()

    class Viewholder(view:View) : RecyclerView.ViewHolder(view){
        val kinygyoview:ImageView = view.findViewById(R.id.imageView8)
        val kingyoname:TextView = view.findViewById(R.id.fishname)
        val kingyonumber:TextView = view.findViewById(R.id.textView9)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_fishlibrary_data_cell,parent,false)
        return Viewholder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
       val item =items[position]
        holder.kinygyoview.setImageResource(item.fishimage)
        holder.kingyoname.text = item.fishName
        holder.kingyonumber.text = item.fishnumber

    }

    fun addAll(items:List<Fish_library_data>){
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}