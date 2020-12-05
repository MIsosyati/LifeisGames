package com.lifeistech.android.lifeisgames.kingyosukui

import io.realm.RealmObject

open class Fish_library_data (var fishimage: Int = 0,
      var fishnumber:String = "",
      var fishName: String = "",
      var fish_option: String = "",
      var fish_category: String = "",
      var isCatched: Boolean = false
): RealmObject()