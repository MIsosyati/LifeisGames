package com.lifeistech.android.lifeisgames.kingyosukui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.lifeistech.android.lifeisgames.R
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_fishlibrary.*

class FishlibraryActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fishlibrary)

        val realm = Realm.getDefaultInstance()


       var adapter = Recyclerviewadapter(this)
        recyclerView.layoutManager = GridLayoutManager(this, 3)
        recyclerView.adapter = adapter
        adapter.addAll(realm.where(Fish_library_data::class.java).findAll())
    }
}