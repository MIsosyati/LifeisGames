package com.lifeistech.android.lifeisgames

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlinx.android.synthetic.main.activity_main.*


var realm: Realm = Realm.getDefaultInstance()
private val ur: UseRealm = UseRealm()
class MainActivity : AppCompatActivity() {

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //最終的にはアプリ選択する画面でここだけ書く
        Realm.init(this)
        val config = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.setDefaultConfiguration(config)


        setTitle( "ホーム画面" );

        coinlayout.visibility = View.INVISIBLE;

        button1.setOnClickListener {
            val intent = Intent(this, PMSActivity::class.java)
            startActivity(intent)
        }
        button2.setOnClickListener {
            val intent = Intent(this, BlockBreakingMainActivity::class.java)
            startActivity(intent)
        }
        button3.setOnClickListener {
            val intent = Intent(this, DrawMainActivity::class.java)
            startActivity(intent)
        }
        button4.setOnClickListener {
            val intent = Intent(this, RealMainActivity::class.java)
            startActivity(intent)
        }
        button5.setOnClickListener {
            val intent = Intent(this, KingyoMainActivity::class.java)
            startActivity(intent)
        }
    }

    fun gooption(){

    }






    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }
}