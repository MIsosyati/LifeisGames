package com.lifeistech.android.lifeisgames.drawkt

import android.content.Context
import android.content.Intent
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class PaintViewa @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {

    private val MODE_BLACK = 0
    private val MODE_WHITE = 1

    private val paint: Paint
    private val path: Path

    private val paint2: Paint
    private val path2: Path

    private val rectPaint: Paint
    private val linePaint: Paint

    private var initDraw = false

    private var sizeX:Float? = null
    private var sizeY:Float? = null


    var currentMode = MODE_BLACK


    //変更：initはまとめてもOK
    init {
        path = Path()
        paint = Paint()
        //変更：分かりやすくするためにColor型の黒を使用．内部数値的には0xFF000000
        paint.color = Color.BLACK
        paint.style = Paint.Style.STROKE
        paint.strokeJoin = Paint.Join.ROUND
        paint.strokeCap = Paint.Cap.ROUND
        paint.strokeWidth = 10f

        path2 = Path()
        paint2 = Paint()
        //変更：分かりやすくするためにColor型の赤を使用．内部数値的には0xFFFF0000
        paint2.color = Color.BLUE
        paint2.style = Paint.Style.STROKE
        paint2.strokeJoin = Paint.Join.ROUND
        paint2.strokeCap = Paint.Cap.ROUND
        paint2.strokeWidth = 10f

        rectPaint = Paint()
        rectPaint.color = Color.GRAY
        rectPaint.style = Paint.Style.STROKE
        rectPaint.strokeJoin = Paint.Join.ROUND
        rectPaint.strokeCap = Paint.Cap.ROUND
        rectPaint.strokeWidth = 10f

        linePaint = Paint()
        linePaint.color = Color.GRAY
        linePaint.style = Paint.Style.STROKE
        linePaint.strokeJoin = Paint.Join.ROUND
        linePaint.strokeCap = Paint.Cap.ROUND
        linePaint.strokeWidth = 3f

    }

    fun setSize(x:Float, y:Float){
        sizeX = x
        sizeY = y
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawPath(path, paint)
        canvas.drawPath(path2, paint2)

        if(sizeX != null && sizeY != null) {
            canvas.drawRect(0f, 0f, sizeX!!, sizeY!!, rectPaint)

            var lineX = 0f
            var lineY = 0f
            val width = sizeX!! / 10f
            val height = sizeY!! / 10f

            for(i in 1..9){
                lineX += height
                lineY += width
                canvas.drawLine(0f, lineX, sizeX!!, lineX, linePaint)
                canvas.drawLine(lineY, 0f, lineY, sizeY!!, linePaint)
            }
        }
    }



    override fun onTouchEvent(event: MotionEvent): Boolean {

        val x = event.x
        val y = event.y

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                when(currentMode){
                    MODE_BLACK -> {
                        path.moveTo(x, y)
                    }
                    MODE_WHITE -> {
                        path2.moveTo(x, y)
                    }
                }
            }
            MotionEvent.ACTION_MOVE -> {
                when(currentMode){
                    MODE_BLACK -> {
                        path.lineTo(x, y)
                    }
                    MODE_WHITE -> {
                        path2.lineTo(x, y)
                    }
                }
            }
            MotionEvent.ACTION_UP -> {
                when(currentMode){
                    MODE_BLACK -> {
                        path.lineTo(x, y)
                    }
                    MODE_WHITE -> {
                        path2.lineTo(x, y)
                    }
                }
            }
        }

        invalidate()
        return true
    }

    fun clear(){
        path.reset()
        path2.reset()
        invalidate()
    }



    //追加：MainActivity側でpaintView.setBlackを実行すると黒色に，paintView.setRedを実行すると赤色になる
    fun setBlack(){
        currentMode = MODE_BLACK
    }

    fun setWhite(){
        currentMode = MODE_WHITE
    }
}

