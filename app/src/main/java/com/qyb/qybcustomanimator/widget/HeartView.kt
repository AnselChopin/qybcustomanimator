package com.qyb.qybcustomanimator.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import com.qyb.qybcustomanimator.R
import com.qyb.qybcustomanimator.util.PhoneSize

/**
 * Created by Qing Yuanbiao.
 * Created on 2017/12/7.
 * Desc:
 */
class HeartView : View {

    var phoneWidth = 0f
    var phoneHeight = 0f
    var centerX = 0f
    var centerY = 0f
    lateinit var mPaint : Paint

    constructor(context: Context) : super(context){init()}

    constructor(context: Context,attributeSet: AttributeSet) : super(context,attributeSet){init()}

    constructor(context: Context,attributeSet: AttributeSet,defStyleAttr: Int) : super(context,attributeSet,defStyleAttr){init()}

    private fun init(){
        phoneWidth = PhoneSize.getPhoneWidth(context).toFloat()
        phoneHeight = PhoneSize.getPhoneHeight(context).toFloat()
        centerX = phoneWidth / 2
        centerY = phoneHeight / 2

        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mPaint.style = Paint.Style.FILL
        mPaint.color = resources.getColor(R.color.colorAccent)
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        var p = Path()
        p.moveTo(centerX, phoneHeight*7/25)
        p.cubicTo(phoneWidth*409/600, phoneHeight*69/500,
                phoneWidth*538/600, phoneHeight*222/500,
                centerX, phoneHeight*7/10)
        p.cubicTo(
                phoneWidth-phoneWidth*538/600,phoneHeight*222/500,
                phoneWidth-phoneWidth*409/600,phoneHeight*69/500,
                centerX, phoneHeight*7/25)

        canvas?.drawPath(p,mPaint)
    }

}