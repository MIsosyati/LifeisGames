package com.lifeistech.android.lifeisgames

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.lifeistech.android.lifeisgames.kingyosukui.FishlibraryActivity
import kotlinx.android.synthetic.main.activity_kingyomain.*


class KingyoMainActivity : AppCompatActivity() {

    override fun onSupportNavigateUp(): Boolean {
        val intent = Intent(application, MainActivity::class.java)
        startActivity(intent)
        finish()
        return super.onSupportNavigateUp()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kingyomain)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setTitle( "金魚すくい" );

        button.setOnClickListener {
            val intent= Intent(this, Yataiactivity::class.java)
            startActivity(intent);
        }

        button2.setOnClickListener {
            val intent= Intent(this, ShopActivity::class.java)
            startActivity(intent);
        }

        zukanbutton.setOnClickListener {
            val intent= Intent(this, FishlibraryActivity::class.java)
            startActivity(intent);
        }

        Rankbutton.setOnClickListener {
            val toast=  Toast.makeText(applicationContext, "Coming soon.....", Toast.LENGTH_SHORT).show()

        }



    }



}
