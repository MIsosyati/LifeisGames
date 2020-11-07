package com.lifeistech.android.lifeisgames


import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_pms.*

class PMSActivity : AppCompatActivity() {

    override fun onSupportNavigateUp(): Boolean {
        val intent = Intent(application, MainActivity::class.java)
        startActivity(intent)
        finish()
        return super.onSupportNavigateUp()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pms)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setTitle( "マインスイーパー：ホーム" );

        blevel1.setOnClickListener {
            warp(1)
        }
        blevel2.setOnClickListener {
            warp(2)
        }
        blevel3.setOnClickListener {
            warp(3)
        }
        bshop.setOnClickListener {
            val intent = Intent(this, MSShopActivity::class.java)
            startActivity(intent)
        }
        blevel1.setOnLongClickListener{
            dialog(1)
            true
        }
        blevel2.setOnLongClickListener{
            dialog(2)
            true
        }
        blevel3.setOnLongClickListener{
            dialog(3)
            true
        }
    }
    fun warp(level: Int){
        val intent = Intent(this, MSActivity::class.java)
        intent.putExtra("LEVEL",level)
        startActivity(intent)
    }
    fun dialog(level: Int){
        val data = getSharedPreferences("Data", Context.MODE_PRIVATE)
        var highscore = data.getInt("mshighscore$level", 0)
        AlertDialog.Builder(this) // FragmentではActivityを取得して生成
            .setTitle("ハイスコア")
            .setMessage("ハイスコア:$highscore")
            .setPositiveButton("OK") { _, _ ->
            }
            .show()
    }

}
