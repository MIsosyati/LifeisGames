package com.lifeistech.android.lifeisgames

import io.realm.RealmObject

open class MainRealm(
    open var coin: Int=0,
    open var title: String = "",
    open var content: String = ""
) : RealmObject()