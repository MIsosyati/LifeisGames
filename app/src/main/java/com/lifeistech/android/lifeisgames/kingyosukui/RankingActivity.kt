package com.lifeistech.android.lifeisgames

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lifeistech.android.lifeisgames.kingyosukui.Rankingrealm
import io.realm.Realm
import io.realm.RealmConfiguration
class Ranking : AppCompatActivity() {

    val realm: Realm = Realm.getDefaultInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ranking)
    }




    fun read(): Rankingrealm?{
        return realm.where(Rankingrealm::class.java).findFirst()


    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }


}
