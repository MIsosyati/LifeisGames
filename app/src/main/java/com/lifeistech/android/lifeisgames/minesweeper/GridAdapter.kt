package com.lifeistech.android.lifeisgames

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import java.util.*

class GridAdapter(
    private val mContext: Context,
    blockinfo2: IntArray,
    blockvisible2: Array<Boolean?>,
    nowposition2: Int
) : BaseAdapter() {
    private val mLayoutInflater: LayoutInflater
    private val text = arrayOfNulls<String>(49)
    private var blockinfo = IntArray(49)
    private var blockvisible = arrayOfNulls<Boolean>(49)
    private var nowposition = -1
    var data: SharedPreferences
    var holder: ViewHolder

    class ViewHolder {
        var gridImageView: ImageView? = null
        var gridBackView: ImageView? = null
    }

    override fun getCount(): Int {
        Arrays.fill(text,"")
        return text.size
    }

    override fun getItem(position: Int): Any {
        Arrays.fill(text,"")
        return text[position]!!
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View? {
        var convertView = convertView
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.block_layout, null)
            holder.gridImageView =
                convertView.findViewById<View>(R.id.grid_imageview) as ImageView
            holder.gridBackView =
                convertView.findViewById<View>(R.id.grid_backview) as ImageView
            convertView.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
        }
        if (nowposition == position) {
            holder.gridBackView!!.setImageResource(android.R.color.holo_orange_light)
        } else {
            holder.gridBackView!!.setImageResource(R.color.greeen)
        }
        if (blockvisible[position]!!) {
            if (blockinfo[position] == 1) {
                holder.gridImageView!!.setImageResource(R.drawable.numberone)
            } else if (blockinfo[position] == 2) {
                holder.gridImageView!!.setImageResource(R.drawable.numbertwo)
            } else if (blockinfo[position] == 3) {
                holder.gridImageView!!.setImageResource(R.drawable.numberthree)
            } else if (blockinfo[position] == 4) {
                holder.gridImageView!!.setImageResource(R.drawable.numberfour)
            } else if (blockinfo[position] == 5) {
                holder.gridImageView!!.setImageResource(R.drawable.numberfive)
            } else if (blockinfo[position] == 6) {
                holder.gridImageView!!.setImageResource(R.drawable.numbersix)
            } else if (blockinfo[position] == 7) {
                holder.gridImageView!!.setImageResource(R.drawable.numberseven)
            } else if (blockinfo[position] == 8) {
                holder.gridImageView!!.setImageResource(R.drawable.numbereight)
            } else if (blockinfo[position] == 0 || blockinfo[position] == 9) {
                holder.gridImageView!!.setImageResource(R.drawable.frame)
            } else if (blockinfo[position] == 10) {
                holder.gridImageView!!.setImageResource(R.drawable.bang)
            } else if (blockinfo[position] == -1) {
                //バグ
            } else {
                val data = mContext.getSharedPreferences("Data", Context.MODE_PRIVATE)
                val kposition = data.getInt("flagkind", 0)
                val resources = mContext.resources.getIdentifier(
                    "flag$kposition",
                    "drawable",
                    mContext.packageName
                )
                holder.gridImageView!!.setImageResource(resources)
            }
        } else {
            if (blockinfo[position] == -1) {
                holder.gridImageView!!.setImageResource(R.drawable.unknown)
            } else {
                holder.gridImageView!!.setImageResource(R.drawable.unexplored)
            }
        }
        return convertView
    }

    init {
        blockinfo = blockinfo2
        blockvisible = blockvisible2
        nowposition = nowposition2
        mLayoutInflater = LayoutInflater.from(mContext)
        data = PreferenceManager.getDefaultSharedPreferences(mContext)
        holder = ViewHolder()
    }
}