package com.lifeistech.android.lifeisgames

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.AdapterView.OnItemClickListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_msshop.*
import java.util.*

class MSShopActivity : AppCompatActivity() {
    var adapter: CustomListAdapter? = null
    val images = Array<Int>(3) { it }
    val names = Array<String>(3) { "" }
    val infos = Array<String>(3) { "" }
    val costs = Array<Int>(3) { it }
    var coin = 100

    override fun onSupportNavigateUp(): Boolean {
        val intent = Intent(application, PMSActivity::class.java)
        startActivity(intent)
        finish()
        return super.onSupportNavigateUp()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_msshop)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = "マインスイーパー：ショップ"

        list.onItemClickListener = OnItemClickListener { parent, view, position, id ->
            buyflag(position)
        }
        getdata()
    }

    fun toastMake(message: String, x: Int, y: Int) {
        val toast = Toast.makeText(applicationContext, message, Toast.LENGTH_LONG)
        // 位置調整
        toast.setGravity(Gravity.CENTER, x, y)
        toast.show()
    }

    fun show() {
        cointext.text = "店主：いらっしゃい！\n今流行りの旗はいかが？いつも99%OFFダヨ！\n(今は全部無料です)"
        //お客さんは今$coin コイン持ってるね～
        adapter = CustomListAdapter(this, images, names, infos)
        list.adapter = adapter
    }

    var possess = Array<Boolean>(100) { false }
    var using = -1
    fun getdata() {
        val data = getSharedPreferences("Data", Context.MODE_PRIVATE)
        val editor = getSharedPreferences("Data", Context.MODE_PRIVATE).edit()
        for (i in 0..99){
            possess[i] = data.getBoolean("possess"+i,false)
        }
        possess[0] = true
        possess[1] = true
        possess[2] = true
        using = data.getInt("flagkind",0)
        coin = data.getInt("coin",100)
        //
        names[0] = "お花"
        names[1] = "お花Lv2"
        names[2] = "お花Lv3"
        costs[0] = 0
        costs[1] = 10
        costs[2] = 100
        for(i in 0..2){
            if(possess[i]){
                //持っている
                if(using==i){
                    infos[i] = "使用中"
                }else{
                    infos[i] = "購入済み"
                }
            }else{
                //持っていない
                infos[i] = costs[i].toString()
                infos[i] += "コイン"
            }
        }
        show()
    }
    fun buyflag(i:Int){
        val data = getSharedPreferences("Data", Context.MODE_PRIVATE)
        val editor = getSharedPreferences("Data", Context.MODE_PRIVATE).edit()
        if(possess[i]){
            //持っている
            editor.putInt("flagkind",i)
            editor.apply()
            getdata()
        }else{
            if(coin>=costs[i]){
                //購入可能
                val toastMessage = "毎度あり～"
                toastMake(toastMessage,0,-200)
                editor.putBoolean("possess"+i,true)
                editor.apply()
                coin -= costs[i]
                getdata()
            }
        }
    }
}
