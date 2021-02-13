package com.lifeistech.android.lifeisgames

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.lifeistech.android.lifeisgames.kingyosukui.Fish_library_data
import com.lifeistech.android.lifeisgames.kingyosukui.Rankingrealm
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmQuery
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.activity_yatai.*
import java.util.*
import kotlin.math.cos
import kotlin.math.sin
import kotlin.random.Random
import com.lifeistech.android.lifeisgames.realm as realm

class Yataiactivity : AppCompatActivity() {


    override fun onSupportNavigateUp(): Boolean {
        val intent = Intent(application, KingyoMainActivity::class.java)
        startActivity(intent)
        finish()
        return super.onSupportNavigateUp()
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yatai)

        val realm: Realm = Realm.getDefaultInstance()


        var data = realm.where(Rankingrealm::class.java).findFirst()
        if (data == null){
//            realm.executeTransaction {
//                data = it.createObject(Rankingrealm::class.java)
//            }

        }



        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setTitle( "金魚すくい：屋台" );

        backbutton.setOnClickListener {
            finish()
        }

        button7.setOnClickListener {
            val intent= Intent(this, ShopActivity::class.java)
            startActivity(intent);
        }

        var kingyo1 = popKingyo(imageView1)
        var kingyo2 = popKingyo(imageView2)
        var kingyo3 = popKingyo(imageView3)
        var kingyo4 = popKingyo(imageView4)
        var kingyo5 = popKingyo(imageView5)
        var kingyo6 = popKingyo(imageView6)
        var kingyo7 = popKingyo(imageView7)

        //すくえるか否かの判定用
        var hantei = 0
        //このゲームの所持金
        var tuca = 100
        //ポイの値段
        var catchvalue = 5
        textView4.text = tuca.toString() + "ポイント"

//        var fisharraylist = arrayListOf<String>()
//        var fishlist = realm.where<Fish_library_data>().findAll()


        //変更：アニメーションのランダム化
        //変更：それに伴いvalからvarに変更，名前も分かりやすくするため変更
        var imageView1AnimSet = randomAnim(kingyo1.imageView)
        var imageView2animSet = randomAnim(kingyo2.imageView)
        var imageView3animSet = randomAnim(kingyo3.imageView)
        var imageView4animSet = randomAnim(kingyo4.imageView)
        var imageView5animSet = randomAnim(kingyo5.imageView)
        var imageView6animSet = randomAnim(kingyo6.imageView)
        var imageView7animSet = randomAnim(kingyo7.imageView)


        kingyo1.imageView.setOnClickListener {
            tuca = tuca - catchvalue
            textView4.text = tuca.toString() + "ポイント"
            hantei = Random.nextInt(100)
            if (hantei <= kingyo1.hantei) {
                if (data != null) {
                    realm.executeTransaction {
                        data.kingyogoukei++
                    }
                }

                checkLibrary(kingyo1.name)

                textView3.text = kingyo1.name + """を掬いました!
            |ポイント＋""".trimMargin() + kingyo1.value
                tuca = tuca + kingyo1.value
                textView4.text = tuca.toString() + "ポイント"
                kingyo1.imageView.visibility = View.GONE
                kingyo1 = popKingyo(imageView1)
            } else {
                textView3.text = "穴が開いて金魚が落ちてしまった"
            }
        }

        kingyo2.imageView.setOnClickListener {
            tuca = tuca - catchvalue
            textView4.text = tuca.toString() + "ポイント"
            hantei = Random.nextInt(100)
            if (hantei <= kingyo2.hantei) {
                if (data != null) {
                    realm.executeTransaction {
                        data.kingyogoukei++
                    }
                }
                checkLibrary(kingyo2.name)

                textView3.text = kingyo2.name + """を掬いました!
            |ポイント＋""".trimMargin() + kingyo2.value
                tuca = tuca + kingyo2.value
                textView4.text = tuca.toString() + "ポイント"
                kingyo2.imageView.visibility = View.GONE
                kingyo2 = popKingyo(imageView2)
            } else {
                textView3.text = "穴が開いて金魚が落ちてしまった"
            }
        }


        kingyo3.imageView.setOnClickListener {
            tuca = tuca - catchvalue
            textView4.text = tuca.toString() + "ポイント"
            hantei = Random.nextInt(100)
            if (hantei <=kingyo3.hantei) {
                if (data != null) {
                    realm.executeTransaction {
                        data.kingyogoukei++
                    }
                }
                checkLibrary(kingyo3.name)
                textView3.text = kingyo3.name + """を掬いました!
            |ポイント＋""".trimMargin() + kingyo3.value
                tuca = tuca + kingyo3.value
                textView4.text = tuca.toString() + "ポイント"
                kingyo3.imageView.visibility = View.GONE
                kingyo3 = popKingyo(imageView3)

            } else {
                textView3.text = "穴が開いて金魚が落ちてしまった"
            }
        }

        kingyo4.imageView.setOnClickListener {
            tuca = tuca - catchvalue
            textView4.text = tuca.toString() + "ポイント"
            hantei = Random.nextInt(100)
            if (hantei <= kingyo4.hantei) {
                if (data != null) {
                    realm.executeTransaction {
                        data.kingyogoukei++
                    }
                }
                checkLibrary(kingyo4.name)
                textView3.text = kingyo4.name + """を掬いました!
            |ポイント＋""".trimMargin() + kingyo4.value
                tuca = tuca + kingyo4.value
                textView4.text = tuca.toString() + "ポイント"
                kingyo4.imageView.visibility = View.GONE
                kingyo4 = popKingyo(imageView4)

            } else {
                textView3.text = "穴が開いて金魚が落ちてしまった"
            }
        }



        kingyo5.imageView.setOnClickListener {
            tuca = tuca - catchvalue
            textView4.text = tuca.toString() + "ポイント"
            hantei = Random.nextInt(100)
            if (hantei <= kingyo5.hantei) {
                if (data != null) {
                    realm.executeTransaction {
                        data.kingyogoukei++
                    }
                }
                checkLibrary(kingyo5.name)
                textView3.text = kingyo5.name + """を掬いました!
            |ポイント＋""".trimMargin() + kingyo5.value
                tuca = tuca + kingyo5.value
                textView4.text = tuca.toString() + "ポイント"
                kingyo5.imageView.visibility = View.GONE
                kingyo5 = popKingyo(imageView5)
            } else {
                textView3.text = "穴が開いて金魚が落ちてしまった"
            }
        }

        kingyo6.imageView.setOnClickListener {
            tuca = tuca - catchvalue
            textView4.text = tuca.toString() + "ポイント"
            hantei = Random.nextInt(100)

            if (hantei <= kingyo6.hantei) {
                if (data != null) {
                    realm.executeTransaction {
                        data.kingyogoukei++
                    }
                }
                checkLibrary(kingyo6.name)
                textView3.text = kingyo6.name + """を掬いました!
            |ポイント＋""".trimMargin() + kingyo6.value
                tuca = tuca + kingyo1.value
                textView4.text = tuca.toString() + "ポイント"
                kingyo6.imageView.visibility = View.GONE
                kingyo6 = popKingyo(imageView6)


            } else {
                textView3.text = "穴が開いて金魚が落ちてしまった"
            }
        }

        kingyo7.imageView.setOnClickListener {
            tuca = tuca - catchvalue
            textView4.text = tuca.toString() + "ポイント"
            hantei = Random.nextInt(100)
            if (hantei <= kingyo7.hantei) {
                if (data != null) {
                    realm.executeTransaction {
                        data.kingyogoukei++
                    }
                }
                checkLibrary(kingyo7.name)

                textView3.text = kingyo7.name + """を掬いました!
            |ポイント＋""".trimMargin() + kingyo7.value
                tuca = tuca + kingyo7.value
                textView4.text = tuca.toString() + "ポイント"
                kingyo7.imageView.visibility = View.GONE
                kingyo7 = popKingyo(imageView7)

            } else {
                textView3.text = "穴が開いて金魚が落ちてしまった"
            }
        }





        //アニメーションを開始します
        //変更：アニメーション終了時に再度ランダムで抽選してアニメーションを設定
        setAnimRepeat(imageView1AnimSet, kingyo1.imageView)
        imageView1AnimSet.start()

//2個目の動きを作るよ
        setAnimRepeat(imageView2animSet, kingyo2.imageView)
        imageView2animSet.start()

        setAnimRepeat(imageView3animSet, kingyo3.imageView)
        imageView3animSet.start()

        setAnimRepeat(imageView4animSet, kingyo4.imageView)
        imageView4animSet.start()

        setAnimRepeat(imageView5animSet, kingyo5.imageView)
        imageView5animSet.start()

        setAnimRepeat(imageView6animSet, kingyo6.imageView)
        imageView6animSet.start()

        setAnimRepeat(imageView7animSet, kingyo7.imageView)
        imageView7animSet.start()
    }
    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }
}


private fun checkLibrary(fishName: String){
    val data: Fish_library_data? = realm.where(Fish_library_data::class.java).equalTo("fishName", fishName).findFirst()
    realm.executeTransaction {
        data?.isCatched = true
    }
}



//ランダムにアニメーションを設定するメソッド
private fun randomAnim(view:ImageView):AnimatorSet{
    // アニメーションの個数が増えたら..の後の値とwhenの分岐を増やすこと
    val rand = (1..3).random()
    Log.d("random", "${view} = $rand")
    return when(rand){
        1 -> setAnim1(view)
        2 -> setAnim2(view)
        3 -> setAnim3(view)

        else -> setAnim1(view)
    }
}


private fun setAnimRepeat(set:AnimatorSet, view:ImageView){
    set.addListener(object : Animator.AnimatorListener {
        override fun onAnimationEnd(p0: Animator?) {
            val next = randomAnim(view)
            setAnimRepeat(next, view)
            next.start()
            view.visibility = View.VISIBLE

        }

        override fun onAnimationRepeat(p0: Animator?) {}
        override fun onAnimationCancel(p0: Animator?) {
            val next = randomAnim(view)
            setAnimRepeat(next, view)
            next.start()
            view.visibility = View.VISIBLE
        }
        override fun onAnimationStart(p0: Animator?) {}
    })
}
//金魚の確率設定
private fun popKingyo(view: ImageView):Base{
    val pop = Random.nextInt(185)
    when{
        pop < 15 -> {
            val kingyo = WakinB(view)
            kingyo.imageView.setImageResource(R.drawable.kingyo)
            return kingyo
        }
        pop < 30 -> {
            val kingyo = WakinR(view)
            kingyo.imageView.setImageResource(R.drawable.kingyo)
            return kingyo
        }
        pop <45  -> {
            val kingyo = WakinS(view)
            kingyo.imageView.setImageResource(R.drawable.kingyo)
            return kingyo
        }
        pop < 50 -> {
            val kingyo = DemeB(view)
            kingyo.imageView.setImageResource(R.drawable.kingyo)
            return kingyo
        }

        pop < 55 -> {
            val kingyo = DemeB(view)
            kingyo.imageView.setImageResource(R.drawable.deme)
            return kingyo
        }

        pop < 60 -> {
            val kingyo = DemeR(view)
            kingyo.imageView.setImageResource(R.drawable.deme)
            return kingyo
        }
        pop < 65 -> {
            val kingyo = DemeR(view)
            kingyo.imageView.setImageResource(R.drawable.kingyo)
            return kingyo
        }
        pop <75 -> {
            val kingyo = DemeS(view)
            kingyo.imageView.setImageResource(R.drawable.kingyo)
            return kingyo

        }

        pop <85 -> {
            val kingyo = Rantyu(view)
            kingyo.imageView.setImageResource(R.drawable.kingyo)
            return kingyo

        }

        pop <95 -> {
            val kingyo = RantyuR(view)
            kingyo.imageView.setImageResource(R.drawable.kingyo)
            return kingyo

        }

        pop <105 -> {
            val kingyo = RantyuW(view)
            kingyo.imageView.setImageResource(R.drawable.kingyo)
            return kingyo

        }

        pop <110 -> {
            val kingyo = Tantyou(view)
            kingyo.imageView.setImageResource(R.drawable.kingyo)
            return kingyo

        }

        pop <115 -> {
            val kingyo = Pinpom(view)
            kingyo.imageView.setImageResource(R.drawable.kingyo)
            return kingyo

        }

        pop <120 -> {
            val kingyo = Syubun(view)
            kingyo.imageView.setImageResource(R.drawable.kingyo)
            return kingyo

        }

        pop <125 -> {
            val kingyo = Tokyo(view)
            kingyo.imageView.setImageResource(R.drawable.kingyo)
            return kingyo

        }

        pop <130 -> {
            val kingyo = Kometto(view)
            kingyo.imageView.setImageResource(R.drawable.kingyo)
            return kingyo

        }

        pop <135 -> {
            val kingyo = Sakura(view)
            kingyo.imageView.setImageResource(R.drawable.kingyo)
            return kingyo
        }

        pop <140 -> {
            val kingyo = Suihou(view)
            kingyo.imageView.setImageResource(R.drawable.kingyo)
            return kingyo
        }

        pop <145 -> {
            val kingyo = Oranda(view)
            kingyo.imageView.setImageResource(R.drawable.kingyo)
            return kingyo
        }

        pop <150 -> {
            val kingyo = Azuma(view)
            kingyo.imageView.setImageResource(R.drawable.kingyo)
            return kingyo
        }

        pop <158 -> {
            val kingyo = Rukin(view)
            kingyo.imageView.setImageResource(R.drawable.kingyo)
            return kingyo
        }

        pop <166 -> {
            val kingyo = RukinK(view)
            kingyo.imageView.setImageResource(R.drawable.kingyo)
            return kingyo
        }

        pop <171 -> {
            val kingyo = Tyoten(view)
            kingyo.imageView.setImageResource(R.drawable.kingyo)
            return kingyo
        }
        pop <180 -> {
            val kingyo = numaebi(view)
            kingyo.imageView.setImageResource(R.drawable.kingyo)
            return kingyo
        }
        pop <183 -> {
            val kingyo = tensi(view)
            kingyo.imageView.setImageResource(R.drawable.kingyo)
            return kingyo
        }
        pop <186 -> {
            val kingyo = honoo(view)
            kingyo.imageView.setImageResource(R.drawable.kingyo)
            return kingyo
        }
        pop <189 -> {
            val kingyo = honooG(view)
            kingyo.imageView.setImageResource(R.drawable.kingyo)
            return kingyo
        }
        pop <192 -> {
            val kingyo = cake(view)
            kingyo.imageView.setImageResource(R.drawable.kingyo)
            return kingyo
        }
        else -> {
            val kingyo = Oosan(view)
            kingyo.imageView.setImageResource(R.drawable.kingyo)
            return kingyo
        }
    }



}



// 追加：別のViewにも同じアニメーションを設定できるようメソッドとして切り分け
private fun setAnim1(v: ImageView): AnimatorSet {
    //追加：移動元・今の座標
    var fromX: Float = 0f
    var fromY: Float = 0f
    //変更：移動先・次の座標
    var toX: Float = 0f
    var toY: Float = 0f
    //変更：translationAnim用の変数
    var degree: Double = 0.0
    var distance: Float = 0f
    var holderX: PropertyValuesHolder
    var holderY: PropertyValuesHolder

    //＜＞リストにアニメ操作を集めてまとめて実行させる
    val animatorList = arrayListOf<Animator>()

    //alphaプロパティを0fから1fに変化させます（フェードイン）
    val objectAnimator: ObjectAnimator = ObjectAnimator.ofFloat(v, "alpha", 0f, 1f)
    //3秒かけて実行させます
    objectAnimator.duration = 3000
    //方向変える
    val floatAnima = ObjectAnimator.ofFloat(v, "rotation", 0f, 105f)
    // 3秒かけて実行させます
    floatAnima.duration = 1050

//角度にさっき回転させた数字を当て込む
    degree = 25.0
    distance = 600f
    //追加：移動先の座標を加算
    toX = fromX + (distance * cos(Math.toRadians(degree))).toFloat()
    toY = fromY + (distance * sin(Math.toRadians(degree))).toFloat()
    // translationXプロパティを0fからtoXに変化させます距離と角度から到達点となるX座標、Y座標を求めます
    holderX = PropertyValuesHolder.ofFloat("translationX", fromX, toX)
    // translationYプロパティを0fからtoYに変化させます
    holderY = PropertyValuesHolder.ofFloat("translationY", fromY, toY)
    // targetに対してholderX, holderY, holderRotationを同時に実行させます
    val susumuAnima = ObjectAnimator.ofPropertyValuesHolder(v, holderX, holderY)
    susumuAnima.duration = 4000
    //追加：現在の座標を更新
    fromX = toX
    fromY = toY
    //方向変える
    val floatAnima2 = ObjectAnimator.ofFloat(v, "rotation", 105f, 180f)
    // 3秒かけて実行させます
    floatAnima2.duration = 1200
    //角度にさっき回転させた数字を当て込む
    distance = 200f
    //追加：次の座標を計算
    toX = fromX + (distance * cos(Math.toRadians(degree))).toFloat() * -1f
    toY = fromY + (distance * sin(Math.toRadians(degree))).toFloat()
    // translationXプロパティを0fからtoXに変化させます距離と角度から到達点となるX座標、Y座標を求めます
    holderX = PropertyValuesHolder.ofFloat("translationX", fromX, toX)
    // translationYプロパティを0fからtoYに変化させます
    holderY = PropertyValuesHolder.ofFloat("translationY", fromY, toY)
    // targetに対してholderX, holderY, holderRotationを同時に実行させます
    val susumuAnima2 = ObjectAnimator.ofPropertyValuesHolder(v, holderX, holderY)
    susumuAnima2.duration = 4000
    //追加：現在の座標を更新
    fromX = toX
    fromY = toY

    //追加実装：アニメーションを更に増やす場合は以下に記述すること
    distance = 350f
    //角度も加えてみようぜ
    val holderRotaion =
        PropertyValuesHolder.ofFloat("rotation", 180f, 163f)

    toX = fromX + (distance * cos(Math.toRadians(degree))).toFloat() * -1f
    toY = fromY + (distance * sin(Math.toRadians(degree))).toFloat()
    // translationXプロパティを0fからtoXに変化させます距離と角度から到達点となるX座標、Y座標を求めます
    holderX = PropertyValuesHolder.ofFloat("translationX", fromX, toX)
    // translationYプロパティを0fからtoYに変化させます
    holderY = PropertyValuesHolder.ofFloat("translationY", fromY, toY)
    // targetに対してholderX, holderY, holderRotationを同時に実行させます
    val susumuAnima3 = ObjectAnimator.ofPropertyValuesHolder(v, holderX, holderY, holderRotaion)
    susumuAnima3.duration = 4000
    //追加：現在の座標を更新
    fromX = toX
    fromY = toY

    //方向転換させます

    val floatAnima3 = ObjectAnimator.ofFloat(v, "rotation", 163f, 80f)
    // 3秒かけて実行させます
    floatAnima3.duration = 2000

    //このムーブ最後の動作にする
    distance = 500f
    //追加：移動先の座標を加算
    toX = fromX + (distance * cos(Math.toRadians(degree))).toFloat()
    toY = fromY + (distance * sin(Math.toRadians(degree))).toFloat()
    // translationXプロパティを0fからtoXに変化させます距離と角度から到達点となるX座標、Y座標を求めます
    holderX = PropertyValuesHolder.ofFloat("translationX", fromX, toX)
    // translationYプロパティを0fからtoYに変化させます
    holderY = PropertyValuesHolder.ofFloat("translationY", fromY, toY)
    // targetに対してholderX, holderY, holderRotationを同時に実行させます
    val finishAnima = ObjectAnimator.ofPropertyValuesHolder(v, holderX, holderY)
    finishAnima.duration = 4850
    //追加：現在の座標を更新
    fromX = toX
    fromY = toY


    //こっちはフェードアウトさせてる増やすならこの前
    val kieruAnima: ObjectAnimator = ObjectAnimator.ofFloat(v, "alpha", 1f, 0f)
    //3秒かけて実行させます
    kieruAnima.duration = 3000

    //追加：現在の座標から原点の座標に移動（これ繰り返し地点）
    holderX = PropertyValuesHolder.ofFloat("translationX", fromX, 0f)
    holderY = PropertyValuesHolder.ofFloat("translationY", fromY, 0f)
    val returnAnimation = ObjectAnimator.ofPropertyValuesHolder(v, holderX, holderY)
    returnAnimation.duration = 10

    //アニメの操作の集合体をまとめて処理
    val animatorSet = AnimatorSet()
    // リストに追加します
    animatorList.add(floatAnima)
    animatorList.add(objectAnimator)
    animatorList.add(susumuAnima)
    animatorList.add(floatAnima2)
    animatorList.add(susumuAnima2)
    animatorList.add(susumuAnima3)
    animatorList.add(floatAnima3)
    animatorList.add(finishAnima)
    animatorList.add(kieruAnima)


    //追加実装：更に作成したアニメーションがあればlistに追加すること
    //記述ここまで

    animatorList.add(returnAnimation)
    // リストのAnimatorを順番に実行します
    animatorSet.playSequentially(animatorList)

    return animatorSet
}
//2個目を作ってやろうじゃないか
private fun setAnim2(v: ImageView): AnimatorSet {
    //追加：移動元・今の座標
    var fromX: Float = 0f
    var fromY: Float = 0f
    //変更：移動先・次の座標
    var toX: Float = 0f
    var toY: Float = 0f
    //変更：translationAnim用の変数
    var degree: Double = 0.0
    var distance: Float = 0f
    var holderX: PropertyValuesHolder
    var holderY: PropertyValuesHolder

    //＜＞リストにアニメ操作を集めてまとめて実行させる
    val animatorList = arrayListOf<Animator>()

    //alphaプロパティを0fから1fに変化させます（フェードイン）
    val objectAnimator: ObjectAnimator = ObjectAnimator.ofFloat(v, "alpha", 0f, 1f)
    //3秒かけて実行させます
    objectAnimator.duration = 3000
    //方向変える
    val floatAnima = ObjectAnimator.ofFloat(v, "rotation", 0f, 210f)
    // 3秒かけて実行させます
    floatAnima.duration = 3400


    //角度にさっき回転させた数字を当て込む
    degree = 150.0
    distance = 600f
    //追加：移動先の座標を加算
    toX = fromX + (distance * cos(Math.toRadians(degree))).toFloat()
    toY = fromY + (distance * sin(Math.toRadians(degree))).toFloat()
    // translationXプロパティを0fからtoXに変化させます距離と角度から到達点となるX座標、Y座標を求めます
    holderX = PropertyValuesHolder.ofFloat("translationX", fromX, toX)
    // translationYプロパティを0fからtoYに変化させます
    holderY = PropertyValuesHolder.ofFloat("translationY", fromY, toY)
    // targetに対してholderX, holderY, holderRotationを同時に実行させます
    val susumuAnima = ObjectAnimator.ofPropertyValuesHolder(v, holderX, holderY)
    susumuAnima.duration = 4000
    //追加：現在の座標を更新
    fromX = toX
    fromY = toY
    //方向変える
    val floatAnima2 = ObjectAnimator.ofFloat(v, "rotation", 210f, 350f)
    // 3秒かけて実行させます
    floatAnima2.duration = 4500
    degree =270.0
    distance = 600f
    //追加：移動先の座標を加算y
    toX = fromX + (distance * cos(Math.toRadians(degree))).toFloat()
    toY = fromY + (distance * sin(Math.toRadians(degree))).toFloat()
    // translationXプロパティを0fからtoXに変化させます距離と角度から到達点となるX座標、Y座標を求めます
    holderX = PropertyValuesHolder.ofFloat("translationX", fromX, toX)
    // translationYプロパティを0fからtoYに変化させます
    holderY = PropertyValuesHolder.ofFloat("translationY", fromY, toY)
    // targetに対してholderX, holderY, holderRotationを同時に実行させます
    val susumeruAnima = ObjectAnimator.ofPropertyValuesHolder(v, holderX, holderY)
    susumeruAnima.duration = 4850
    //追加：現在の座標を更新
    fromX = toX
    fromY = toY



    //こっちはフェードアウトさせてる増やすならこの前
    val kieruAnima: ObjectAnimator = ObjectAnimator.ofFloat(v, "alpha", 1f, 0f)
    //3秒かけて実行させます
    kieruAnima.duration = 3000

    //追加：現在の座標から原点の座標に移動（これ繰り返し地点）
    holderX = PropertyValuesHolder.ofFloat("translationX", fromX, 0f)
    holderY = PropertyValuesHolder.ofFloat("translationY", fromY, 0f)
    val returnAnimation = ObjectAnimator.ofPropertyValuesHolder(v, holderX, holderY)
    returnAnimation.duration = 10


    //アニメの操作の集合体をまとめて処理
    val animatorSet = AnimatorSet()
    // リストに追加します
    animatorList.add(floatAnima)
    animatorList.add(objectAnimator)
    animatorList.add(susumuAnima)
    animatorList.add(floatAnima2)
    animatorList.add(susumeruAnima)
    animatorList.add(kieruAnima)
    animatorList.add(returnAnimation)
    // リストのAnimatorを順番に実行します
    animatorSet.playSequentially(animatorList)
    return animatorSet

}

//3個目を作ってやろうじゃないか
private fun setAnim3(v: ImageView): AnimatorSet {
    //追加：移動元・今の座標
    var fromX: Float = 0f
    var fromY: Float = 0f
    //変更：移動先・次の座標
    var toX: Float = 0f
    var toY: Float = 0f
    //変更：translationAnim用の変数
    var degree: Double = 0.0
    var distance: Float = 0f
    var holderX: PropertyValuesHolder
    var holderY: PropertyValuesHolder

    //＜＞リストにアニメ操作を集めてまとめて実行させる
    val animatorList = arrayListOf<Animator>()

    //方向変える
    val floatAnima = ObjectAnimator.ofFloat(v, "rotation", 0f, 90f)

    //alphaプロパティを0fから1fに変化させます（フェードイン）
    val objectAnimator: ObjectAnimator = ObjectAnimator.ofFloat(v, "alpha", 0f, 1f)
    //3秒かけて実行させます
    objectAnimator.duration = 2500


    //角度にさっき回転させた数字を当て込む
    degree = 45.0
    distance = 200f
    //追加：移動先の座標を加算
    toX = fromX + (distance * cos(Math.toRadians(degree))).toFloat()
    toY = fromY + (distance * sin(Math.toRadians(degree))).toFloat()
    // translationXプロパティを0fからtoXに変化させます距離と角度から到達点となるX座標、Y座標を求めます
    holderX = PropertyValuesHolder.ofFloat("translationX", fromX, toX)
    // translationYプロパティを0fからtoYに変化させます
    holderY = PropertyValuesHolder.ofFloat("translationY", fromY, toY)
    // targetに対してholderX, holderY, holderRotationを同時に実行させます
    val susumuAnima = ObjectAnimator.ofPropertyValuesHolder(v, holderX, holderY)
    susumuAnima.duration = 4000
    //追加：現在の座標を更新
    fromX = toX
    fromY = toY

    //方向変える
    val floatAnima2 = ObjectAnimator.ofFloat(v, "rotation", 90f, 160f)
    // 3秒かけて実行させます
    floatAnima2.duration = 2500


    //動かすよ
    degree = 100.0
    distance = 500f
    //追加：移動先の座標を加算
    toX = fromX + (distance * cos(Math.toRadians(degree))).toFloat()
    toY = fromY + (distance * sin(Math.toRadians(degree))).toFloat()
    // translationXプロパティを0fからtoXに変化させます距離と角度から到達点となるX座標、Y座標を求めます
    holderX = PropertyValuesHolder.ofFloat("translationX", fromX, toX)
    // translationYプロパティを0fからtoYに変化させます
    holderY = PropertyValuesHolder.ofFloat("translationY", fromY, toY)
    // targetに対してholderX, holderY, holderRotationを同時に実行させます
    val susumuanima = ObjectAnimator.ofPropertyValuesHolder(v, holderX, holderY)
    susumuanima.duration = 4850
    //追加：現在の座標を更新
    fromX = toX
    fromY = toY


    //こっちはフェードアウトさせてる増やすならこの前
    val kieruAnima: ObjectAnimator = ObjectAnimator.ofFloat(v, "alpha", 1f, 0f)
    //3秒かけて実行させます
    kieruAnima.duration = 3000

    //追加：現在の座標から原点の座標に移動（これ繰り返し地点）
    holderX = PropertyValuesHolder.ofFloat("translationX", fromX, 0f)
    holderY = PropertyValuesHolder.ofFloat("translationY", fromY, 0f)
    val returnAnimation = ObjectAnimator.ofPropertyValuesHolder(v, holderX, holderY)
    returnAnimation.duration = 10


    //アニメの操作の集合体をまとめて処理
    val animatorSet = AnimatorSet()
    // リストに追加します
    animatorList.add(floatAnima)
    animatorList.add(objectAnimator)
    animatorList.add(susumuAnima)
    animatorList.add(floatAnima2)
    animatorList.add(susumuanima)
    animatorList.add(kieruAnima)
    animatorList.add(returnAnimation)
    // リストのAnimatorを順番に実行します
    animatorSet.playSequentially(animatorList)
    return animatorSet


}
