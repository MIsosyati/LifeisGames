package com.lifeistech.android.lifeisgames.kingyosukui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lifeistech.android.lifeisgames.R

class FishlibraryActivity : AppCompatActivity() {
 val fish_library_data: List<Fish_library_data> = listOf(
    Fish_library_data(R.drawable.wakinr,"No.001","ワキン(赤)","金魚の屋台の定番といえばこいつ。金魚の原点ともいえる品種であり先祖はフナ"),
    Fish_library_data(R.drawable.nodata,"No.002","ワキン(黒)","金魚の屋台の定番といえばこいつ。金魚の原点ともいえる品種であり先祖はフナ"),
     Fish_library_data(R.drawable.nodata,"No.003","ワキン(サラサ)","金魚の屋台の定番といえばこいつ。金魚の原点ともいえる品種であり先祖はフナ"),
     Fish_library_data(R.drawable.nodata,"No.004","デメキン(赤)","屋台ではちょっとレア扱い。難易度は低めだが取れると嬉しい反面、目が出てるため弱く、すぐ死ぬ"),
     Fish_library_data(R.drawable.nodata,"No.005","デメキン(黒)","屋台ではちょっとレア扱い。難易度は低めだが取れると嬉しい反面、目が出てるため弱く、すぐ死ぬ"),
     Fish_library_data(R.drawable.nodata,"No.006","デメキン(三色)","屋台ではちょっとレア扱い。難易度は低めだが取れると嬉しい反面、目が出てるため弱く、すぐ死ぬ"),
     Fish_library_data(R.drawable.nodata,"No.007","琉金(赤)","ずんぐりとした体形を持つ。尾が長めのため泳ぐと綺麗。泳ぎは比較的ゆっくりとしている"),
     Fish_library_data(R.drawable.nodata,"No.008","琉金(キャリコ)","ずんぐりとした体形を持つ。尾が長めのため泳ぐと綺麗。泳ぎは比較的ゆっくりとしている"),
     Fish_library_data(R.drawable.nodata,"No.009","蘭鋳(赤)","背びれがなく丸い体形をしている。筆舌すべきは頭の肉瘤である。この肉瘤がライオンを彷彿ああせるため英名はライオンヘッドゴールドフィッシュ"),
     Fish_library_data(R.drawable.nodata,"No.0010","蘭鋳(白)","背びれがなく丸い体形をしている。筆舌すべきは頭の肉瘤である。この肉瘤がライオンを彷彿ああせるため英名はライオンヘッドゴールドフィッシュ"),
     Fish_library_data(R.drawable.nodata,"No.0011" ,"蘭鋳(赤白)","背びれがなく丸い体形をしている。筆舌すべきは頭の肉瘤である。この肉瘤がライオンを彷彿ああせるため英名はライオンヘッドゴールドフィッシュ"),
     Fish_library_data(R.drawable.nodata,"No.0012" ,"朱文金","赤と黒が入り混じった青みのある体をしている。フナやデメキンから派生した品種で丈夫"),
     Fish_library_data(R.drawable.nodata,"No.0013","丹頂","頭部にのみ赤がほかは全て白い体色の金魚。頭部に小さなコブができる。オランダ獅子頭とは別種である"),
     Fish_library_data(R.drawable.nodata,"No.0014","オランダ獅子頭","丹頂と違う点は全身が赤白入り混じっている。またコブも全身にできる。それ以外はほぼ一緒である"),
     Fish_library_data(R.drawable.nodata,"No.0015","東錦","オランダ獅子頭と三色出目金を交配させた品種。色は三色で体形はオランダ獅子頭の特徴を持つ"),
     Fish_library_data(R.drawable.nodata,"No.0016","江戸錦","蘭鋳と東錦を交配させた品種。モザイク透明鱗が特徴で色は赤白浅葱色である"),
     Fish_library_data(R.drawable.nodata,"No.0017" ,"桜錦","蘭鋳と江戸錦を交配させた品種。背びれがなく色は赤と白である"),
     Fish_library_data(R.drawable.nodata,"No.0018" ,"コメット","コメットとは彗星という意味。その名の通り大きくなびく尾びれが特徴"),
     Fish_library_data(R.drawable.nodata,"No.0019" ,"水泡眼","目の下に大きな袋をぶら下げた品種。袋は破れやすく、出目金と同じく弱りやすい"),
     Fish_library_data(R.drawable.nodata,"No.0020" ,"ピンポンパール","まんまるで粒々した体をしている。そのため泳げなくなることも多々あるらしい"),
     Fish_library_data(R.drawable.nodata,"No.0021" ,"頂点眼","名前の通り目が真上を向いている。インパクトがある姿は水槽で見ていて面白い"),
     Fish_library_data(R.drawable.nodata,"No.00000" ,"オオサンショウウオ","特別天然記念物で世界最大級の両生類。寿命は七十年近くある個体も。瞳が可愛い、可愛い。何故こいつが0なのか…それは主の推しだからである。不平不満は認めない")
 )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fishlibrary)
    }
}