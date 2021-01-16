package com.lifeistech.android.lifeisgames

import android.widget.ImageView

open class Base(val name:String, val value:Int, val category: Int, val imageView: ImageView, val hantei:Int){}

class WakinB(imageView: ImageView):Base("ワキン(黒)", 13, 0, imageView,53){}

class WakinR(imageView: ImageView):Base("ワキン(赤)", 13, 0, imageView,53){}

class WakinS(imageView: ImageView):Base("ワキン(サラサ)", 13, 0, imageView,53){}

class DemeR(imageView: ImageView):Base("デメキン(赤)", 14, 0, imageView,38){}

class DemeB(imageView: ImageView):Base("デメキン(黒)", 14, 0, imageView,38){}

class DemeS(imageView: ImageView):Base("デメキン(三色)", 14, 0, imageView,35){}

class Rukin(imageView: ImageView):Base("琉金(赤)", 15, 0, imageView,30){}

class RukinK(imageView: ImageView):Base("琉金(キャリコ)", 15, 0, imageView,30){}

class RantyuR(imageView: ImageView):Base("蘭鋳(赤)", 15, 0, imageView,30){}

class RantyuW(imageView: ImageView):Base("蘭鋳(白)", 15, 0, imageView,30){}

class Rantyu(imageView: ImageView):Base("蘭鋳(赤白)", 15, 0, imageView,30){}

class Tantyou(imageView: ImageView):Base("丹頂", 20, 0, imageView,25){}

class Oranda(imageView: ImageView):Base("オランダ獅子頭", 20, 0, imageView,25){}

class Pinpom(imageView: ImageView):Base("ピンポンパール", 20, 0, imageView,23){}

class Syubun(imageView: ImageView):Base("朱文金", 18, 0, imageView,23){}

class Tokyo(imageView: ImageView):Base("江戸錦", 20, 0, imageView,23){}

class Sakura(imageView: ImageView):Base("桜錦", 20, 0, imageView,23){}

class Azuma(imageView: ImageView):Base("東錦", 20, 0, imageView,23){}

class Kometto(imageView: ImageView):Base("コメット", 20, 0, imageView,23){}

class Suihou(imageView: ImageView):Base("水泡眼", 20, 0, imageView,23){}

class Tyoten(imageView: ImageView):Base("頂点眼", 20, 0, imageView,23){}

class numaebi(imageView: ImageView):Base("ヌマエビ", 15, 0, imageView,40){}

class Oosan(imageView: ImageView):Base("オオサンショウウオ", 100, 0, imageView,15){}



class tensi(imageView: ImageView):Base("天使金魚",60,1,imageView,10){}

class honoo(imageView: ImageView):Base("ファイヤーフィッシュ",35,1,imageView,20){}

class honooG(imageView: ImageView):Base("ファイヤーフィッシュG",45,1,imageView,20){}

class cake(imageView: ImageView):Base("オンザケーキ",50,1,imageView,20){}

class zinbu(imageView: ImageView):Base("ゾンビフィッシュ",25,1,imageView,45){}

class eye(imageView: ImageView):Base("エレガントアイ",30,1,imageView,40){}

//class tensi(imageView: ImageView):Base("",50,1,imageView,20){}







