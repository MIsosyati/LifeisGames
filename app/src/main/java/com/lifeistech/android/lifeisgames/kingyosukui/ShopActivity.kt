package com.lifeistech.android.lifeisgames

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ShopActivity : AppCompatActivity() {
    override fun onSupportNavigateUp(): Boolean {
        val intent = Intent(application, KingyoMainActivity::class.java)
        startActivity(intent)
        finish()
        return super.onSupportNavigateUp()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setTitle( "金魚すくい：ショップ" );

    }
}