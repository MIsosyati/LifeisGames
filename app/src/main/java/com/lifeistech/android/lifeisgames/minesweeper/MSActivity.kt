package com.lifeistech.android.lifeisgames

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_ms.*
import java.util.*
import kotlin.concurrent.schedule


class MSActivity : AppCompatActivity() {
    var blockinfo = IntArray(49)
    var blockvisible = arrayOfNulls<Boolean>(49)
    var nowposition = 0
    var time = 180
    var running = false
    var level = 0
    var maxbomb = 10
    var beforetime = 5
    var highscore = 0

    override fun onSupportNavigateUp(): Boolean {
        val intent = Intent(application, PMSActivity::class.java)
        startActivity(intent)
        finish()
        return super.onSupportNavigateUp()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ms)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = "マインスイーパー"
        val data = getSharedPreferences("Data", Context.MODE_PRIVATE)


        level = intent.getIntExtra("LEVEL", 0)

        highscore = data.getInt("mshighscore$level", 0)

        when (level) {
            1 -> maxbomb = 10
            2 -> maxbomb = 15
            3 -> maxbomb = 20
        }

        errorani.visibility = View.INVISIBLE
        boomani.visibility = View.INVISIBLE


        for (i in 0..48) {
            blockinfo[i] = 0
            blockvisible[i] = false
        }
        blockvisible[24] = true
        var bomb: Int = 0
        while (bomb < maxbomb) {
            var rnds = (0..48).random()
            if (blockinfo[rnds] == 10 || rnds == 24) {
                //既に爆弾が設置されている→無視
            } else {
                blockinfo[rnds] = 10
                bomb++
            }
        }
        for (i in 0..48) {
            if (blockinfo[i] == 10) {
                if (i % 7 == 0) {
                    //左端
                    if (i <= 6) {
                        //上
                        blockinfo[i + 1]++
                        blockinfo[i + 7]++
                        blockinfo[i + 8]++
                    } else if (i >= 42) {
                        //下
                        blockinfo[i - 7]++
                        blockinfo[i - 6]++
                        blockinfo[i + 1]++
                    } else {
                        //真ん中
                        blockinfo[i - 7]++
                        blockinfo[i - 6]++
                        blockinfo[i + 1]++
                        blockinfo[i + 7]++
                        blockinfo[i + 8]++
                    }
                } else if (i % 7 == 6) {
                    //右端
                    if (i <= 6) {
                        //上
                        blockinfo[i - 1]++
                        blockinfo[i + 6]++
                        blockinfo[i + 7]++
                    } else if (i >= 42) {
                        //下
                        blockinfo[i - 8]++
                        blockinfo[i - 7]++
                        blockinfo[i - 1]++
                    } else {
                        //真ん中
                        blockinfo[i - 8]++
                        blockinfo[i - 7]++
                        blockinfo[i - 1]++
                        blockinfo[i + 6]++
                        blockinfo[i + 7]++
                    }
                } else {
                    //真ん中
                    if (i <= 6) {
                        //上
                        blockinfo[i - 1]++
                        blockinfo[i + 1]++
                        blockinfo[i + 6]++
                        blockinfo[i + 7]++
                        blockinfo[i + 8]++
                    } else if (i >= 42) {
                        //下
                        blockinfo[i - 8]++
                        blockinfo[i - 7]++
                        blockinfo[i - 6]++
                        blockinfo[i - 1]++
                        blockinfo[i + 1]++
                    } else {
                        //真ん中
                        blockinfo[i - 8]++
                        blockinfo[i - 7]++
                        blockinfo[i - 6]++
                        blockinfo[i - 1]++
                        blockinfo[i + 1]++
                        blockinfo[i + 6]++
                        blockinfo[i + 7]++
                        blockinfo[i + 8]++
                    }
                }
            }
            for (i in 0..48) {
                if (blockinfo[i] > 10) {
                    blockinfo[i] = 10
                }
            }
        }
        reload()

        bopen.setOnClickListener {
            if (running) {
                if (blockvisible[nowposition]!!) {
                    //既に表示済み
                } else {
                    if (blockinfo[nowposition] == 10) {
                        //コレ爆弾です→爆発→そのまま
                        waitanime++
                        time -= 5
                        timerani.visibility = View.INVISIBLE
                        boomani.visibility = View.VISIBLE
                        showtimeforce()
                    } else {
                        //爆弾じゃない→いいね！→そのまま
                    }
                    blockvisible[nowposition] = true
                    reload()
                }
            }
        }
        bflag.setOnClickListener {
            if (running) {
                if (blockvisible[nowposition]!!) {
                    //既に表示済み
                } else {
                    if (blockinfo[nowposition] == 10) {
                        //コレ爆弾です→フラグ
                        blockinfo[nowposition] = 100
                    } else {
                        //爆弾じゃない→ダメ！→そのまま
                        time -= 5
                        waitanime++
                        timerani.visibility = View.INVISIBLE
                        errorani.visibility = View.VISIBLE
                        showtimeforce()
                    }
                    blockvisible[nowposition] = true
                    reload()
                }
            }
        }
        binfo.setOnClickListener {
            Log.e("aa" + blockvisible[nowposition], "bb" + blockinfo[nowposition])
        }
        gridView.setOnItemClickListener { adapterView, _, position, _ ->
            //Toast.makeText(this, "$position が選択されました",
            //Toast.LENGTH_SHORT).show()
            nowposition = position
            reload()
        }

        // UIスレッドでHandlerを生成（大事！）
        val handler = Handler()
        Timer().schedule(1000, 1000) {
            handler.run {
                post {
                    if (running) {
                        if (time <= 0) {
                            //終了
                            running = false
                            timerani.visibility = View.VISIBLE
                            errorani.visibility = View.INVISIBLE
                            boomani.visibility = View.INVISIBLE
                            if (!endgameshow) {
                                endgame()
                            }
                        } else {
                            time--
                        }
                        timertext.text = "残り時間:$time 秒"
                        if (waitanime > 0) {
                            waitanime--
                        } else {
                            timerani.visibility = View.VISIBLE
                            errorani.visibility = View.INVISIBLE
                            boomani.visibility = View.INVISIBLE
                        }
                    } else if (beforetime >= 0) {
                        if (beforetime == 0) {
                            timertext.text = "残り時間:$time 秒"
                            running = true
                        } else {
                            timertext.text = "開始まで:$beforetime 秒"
                            beforetime--
                        }
                    }
                }
            }
        }
    }

    var waitanime = 0
    fun reload() {
        for (i in 0..48) {
            if (!blockvisible[i]!!) {
                break
            } else if (i == 48) {
                running = false
                if (!endgameshow) {
                    endgame()
                }
            }
        }
        gridView.adapter = GridAdapter(this, blockinfo, blockvisible, nowposition)
    }

    var isitpausing = false
    var endgameshow = false
    fun endgame() {
        endgameshow = true
        if (time > highscore) {
            val data = getSharedPreferences("Data", Context.MODE_PRIVATE)
            val editor = data.edit()
            editor.putInt("mshighscore$level", time)
            editor.apply()
        }
        if (!isitpausing) {
            AlertDialog.Builder(this) // FragmentではActivityを取得して生成
                .setTitle("ゲーム終了")
                .setMessage("お疲れ様！\n今回のスコア:$time \nハイスコア:$highscore")
                .setPositiveButton("OK") { _, _ ->
                    val intent = Intent(this, PMSActivity::class.java)
                    startActivity(intent)
                }
                .setCancelable(false).show()
        }
    }

    fun showtimeforce() {
        timertext.text = "残り時間:$time 秒"
    }

    override fun onPause() {
        super.onPause()
        isitpausing = true
    }
}
