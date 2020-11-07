package com.lifeistech.android.lifeisgames

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomListAdapter // TODO Auto-generated constructor stub
    (
    private val context: Activity,
    private val image: Array<Int>,
    private val title: Array<String>,
    private val subtitle: Array<String>
) : ArrayAdapter<String?>(context, R.layout.mylist, title) {
    override fun getView(
        position: Int,
        view: View?,
        parent: ViewGroup
    ): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.mylist, null, true)
        val txtTitle = rowView.findViewById<View>(R.id.item) as TextView
        val imageView =
            rowView.findViewById<View>(R.id.icon) as ImageView
        val extratxt = rowView.findViewById<View>(R.id.textView1) as TextView
        txtTitle.text = title[position]
        val kposition = image[position]
        val resources = context.resources.getIdentifier(
            "flag$kposition",
            "drawable",
            context.packageName
        )
        imageView.setImageResource(resources)
        extratxt.text = subtitle[position]
        return rowView
    }

}