package com.lifeistech.android.lifeisgames

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.lifeistech.android.lifeisgames.kingyosukui.Fish_library_data
import com.lifeistech.android.lifeisgames.kingyosukui.FishlibraryActivity
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_kingyomain.*


class KingyoMainActivity : AppCompatActivity() {
    val fishLibraryDataList: List<Fish_library_data> = listOf(
        Fish_library_data(R.drawable.wakinr,"No.001","ワキン(赤)","金魚の屋台の定番といえばこいつ。金魚の原点ともいえる品種であり先祖はフナ","リアル"),
        Fish_library_data(R.drawable.nodata,"No.002","ワキン(黒)","金魚の屋台の定番といえばこいつ。金魚の原点ともいえる品種であり先祖はフナ","リアル"),
        Fish_library_data(R.drawable.wakinw,"No.003","ワキン(サラサ)","金魚の屋台の定番といえばこいつ。金魚の原点ともいえる品種であり先祖はフナ","リアル"),
        Fish_library_data(R.drawable.demer,"No.004","デメキン(赤)","屋台ではちょっとレア扱い。難易度は低めだが取れると嬉しい反面、目が出てるため弱く、すぐ死ぬ","リアル"),
        Fish_library_data(R.drawable.demeb,"No.005","デメキン(黒)","屋台ではちょっとレア扱い。難易度は低めだが取れると嬉しい反面、目が出てるため弱く、すぐ死ぬ","リアル"),
        Fish_library_data(R.drawable.demes,"No.006","デメキン(三色)","屋台ではちょっとレア扱い。難易度は低めだが取れると嬉しい反面、目が出てるため弱く、すぐ死ぬ","リアル"),
        Fish_library_data(R.drawable.nodata,"No.007","琉金(赤)","ずんぐりとした体形を持つ。尾が長めのため泳ぐと綺麗。泳ぎは比較的ゆっくりとしている","リアル"),
        Fish_library_data(R.drawable.nodata,"No.008","琉金(キャリコ)","ずんぐりとした体形を持つ。尾が長めのため泳ぐと綺麗。泳ぎは比較的ゆっくりとしている","リアル"),
        Fish_library_data(R.drawable.nodata,"No.009","蘭鋳(赤)","背びれがなく丸い体形をしている。筆舌すべきは頭の肉瘤である。この肉瘤がライオンを彷彿ああせるため英名はライオンヘッドゴールドフィッシュ","リアル"),
        Fish_library_data(R.drawable.nodata,"No.0010","蘭鋳(白)","背びれがなく丸い体形をしている。筆舌すべきは頭の肉瘤である。この肉瘤がライオンを彷彿ああせるため英名はライオンヘッドゴールドフィッシュ","リアル"),
        Fish_library_data(R.drawable.nodata,"No.0011" ,"蘭鋳(赤白)","背びれがなく丸い体形をしている。筆舌すべきは頭の肉瘤である。この肉瘤がライオンを彷彿ああせるため英名はライオンヘッドゴールドフィッシュ","リアル"),
        Fish_library_data(R.drawable.nodata,"No.0012" ,"朱文金","赤と黒が入り混じった青みのある体をしている。フナやデメキンから派生した品種で丈夫","リアル"),
        Fish_library_data(R.drawable.nodata,"No.0013","丹頂","頭部にのみ赤がほかは全て白い体色の金魚。頭部に小さなコブができる。オランダ獅子頭とは別種である","リアル"),
        Fish_library_data(R.drawable.nodata,"No.0014","オランダ獅子頭","丹頂と違う点は全身が赤白入り混じっている。またコブも全身にできる。それ以外はほぼ一緒である","リアル"),
        Fish_library_data(R.drawable.nodata,"No.0015","東錦","オランダ獅子頭と三色出目金を交配させた品種。色は三色で体形はオランダ獅子頭の特徴を持つ","リアル"),
        Fish_library_data(R.drawable.nodata,"No.0016","江戸錦","蘭鋳と東錦を交配させた品種。モザイク透明鱗が特徴で色は赤白浅葱色である","リアル"),
        Fish_library_data(R.drawable.nodata,"No.0017" ,"桜錦","蘭鋳と江戸錦を交配させた品種。背びれがなく色は赤と白である","リアル"),
        Fish_library_data(R.drawable.nodata,"No.0018" ,"コメット","コメットとは彗星という意味。その名の通り大きくなびく尾びれが特徴","リアル"),
        Fish_library_data(R.drawable.nodata,"No.0019" ,"水泡眼","目の下に大きな袋をぶら下げた品種。袋は破れやすく、出目金と同じく弱りやすい","リアル"),
        Fish_library_data(R.drawable.nodata,"No.0020" ,"ピンポンパール","まんまるで粒々した体をしている。そのため泳げなくなることも多々あるらしい","リアル"),
        Fish_library_data(R.drawable.nodata,"No.0021" ,"頂点眼","名前の通り目が真上を向いている。インパクトがある姿は水槽で見ていて面白い","リアル"),
        Fish_library_data(R.drawable.nodata,"No.O-0001" ,"天使金魚","空に恋焦がれた末に羽を手に入れた金魚。しかし体が重いため飛べない","オリジナル"),
        Fish_library_data(R.drawable.nodata,"No.O-0002" ,"ファイヤーフィッシュ","怒りの炎を具現化した金魚。炎を出せるようになったきっかけは失恋らしい。","オリジナル"),
        Fish_library_data(R.drawable.nodata,"No.O-0003" ,"ファイヤーフィッシュG","想いを寄せる彼女が親友と付き合ってることが判明、苦しみでパワーアップしたファイヤーフィッシュの成れの果て","オリジナル"),
        Fish_library_data(R.drawable.nodata,"No.O-0004" ,"オンザケーキ","背中に大きなケーキでオスを引き寄せる、メスしか存在しない。天敵のオスも引き寄せてしまうため絶滅危惧種","オリジナル"),
        Fish_library_data(R.drawable.nodata,"No.O-0005" ,"ゾンビフィッシュ","とある研究所で品種改良された品種、どんな環境でも水さえあれば生き続けるので飼いやすいが見た目が悪いため販売には至られなかった","オリジナル"),
        Fish_library_data(R.drawable.nodata,"No.O-0006" ,"エレガントアイ","美しさを追求した結果目がとても大きくなり模様も目に似るようになった。人間の好みは大きく分かれる。","オリジナル"),
        Fish_library_data(R.drawable.nodata,"No.0100","ヌマエビ","淡水の池などに生息する。足を動かして動く姿が可愛い","その他"),
        Fish_library_data(R.drawable.nodata,"No.00000" ,"オオサンショウウオ","特別天然記念物で世界最大級の両生類。寿命は七十年近くある個体も。瞳が可愛い、可愛い。何故こいつがNO.0なのか…それは主の推しだからである。不平不満は認めない","その他")
    )



    override fun onSupportNavigateUp(): Boolean {
        val intent = Intent(application, MainActivity::class.java)
        startActivity(intent)
        finish()
        return super.onSupportNavigateUp()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kingyomain)

        val realm :Realm = Realm.getDefaultInstance()

        if(realm.where(Fish_library_data::class.java).findAll().isEmpty()){
            realm.executeTransaction {
                fishLibraryDataList.forEach{ fish ->
                    val temp = realm.createObject(Fish_library_data::class.java)
                    temp.fishName = fish.fishName
                    temp.fishnumber = fish.fishnumber
                    temp.isCatched = fish.isCatched
                    temp.fish_category = fish.fish_category
                    temp.fish_option = fish.fish_option
                    temp.fishimage = fish.fishimage

                }

            }

        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setTitle( "金魚すくい" );

        button.setOnClickListener {
            val intent= Intent(this, Yataiactivity::class.java)
            startActivity(intent);
        }

        button2.setOnClickListener {
            val intent= Intent(this, ShopActivity::class.java)
            startActivity(intent);
        }

        zukanbutton.setOnClickListener {
            val intent= Intent(this, FishlibraryActivity::class.java)
            startActivity(intent);
        }

        Rankbutton.setOnClickListener {
            val toast=  Toast.makeText(applicationContext, "Coming soon.....", Toast.LENGTH_SHORT).show()

        }



    }



}
