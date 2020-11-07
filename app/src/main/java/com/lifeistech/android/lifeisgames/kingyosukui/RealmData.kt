package com.lifeistech.android.lifeisgames.kingyosukui

import io.realm.RealmObject

open class Rankingrealm (
    open var name: String = "",
    open var catchvalue: Int = 0,
    open var Tensuu: Int = 0
): RealmObject()