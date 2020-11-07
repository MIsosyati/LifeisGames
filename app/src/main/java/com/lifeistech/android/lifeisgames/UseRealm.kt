package com.lifeistech.android.lifeisgames

import io.realm.Realm

class UseRealm {
    var realm: Realm = Realm.getDefaultInstance()
    fun readcoin():Int{
        val mainrealm:MainRealm? = read()
        var coin:Int
        if(mainrealm!=null){
            coin = mainrealm.coin
        }else{
            coin = 0
        }
        return coin
    }
    fun read():MainRealm?{
        return realm.where(MainRealm::class.java).findFirst()
    }
    fun writecoin(coin:Int):Boolean{
        val mainrealm:MainRealm?=read()
        realm.executeTransaction {
            if(mainrealm!=null){
                mainrealm.coin=coin
            }else{
                val newMainRealm:MainRealm=it.createObject(MainRealm::class.java)
                newMainRealm.coin = coin
            }
        }
        return true
    }
}