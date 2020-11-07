package com.lifeistech.android.lifeisgames

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_drawmain.*

class DrawMainActivity : AppCompatActivity() {

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawmain)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setTitle( "迷路ビルダー" );

        buttonErase.setOnClickListener {
            paintView.setWhite()
        }

        buttonPen.setOnClickListener {
            paintView.setBlack()
        }


        fab.setOnClickListener {
            //  Snackbar.

            AlertDialog.Builder(this) // FragmentではActivityを取得して生成
                .setTitle("ゴミ箱")
                .setMessage("作品を消去しますか？")
                .setPositiveButton("はい") { _, _ ->
                    paintView.clear()
                }
                .setNegativeButton("いいえ") { _, _ ->
                    // TODO:Noが押された時の挙動
                }
                .show()


        }

    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        paintView.setSize(paintView.width.toFloat(), paintView.height.toFloat())
    }
}
