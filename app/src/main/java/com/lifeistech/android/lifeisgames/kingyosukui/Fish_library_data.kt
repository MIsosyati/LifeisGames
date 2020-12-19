package com.lifeistech.android.lifeisgames.kingyosukui

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Fish_library_data(
   open   var fishimage: Int = 0,
   open  var fishnumber:String = "",
    open  var fishName: String = "",
    open  var fish_option: String = "",
    open  var fish_category: String = "",
    open  var isCatched: Boolean = false
): RealmObject()