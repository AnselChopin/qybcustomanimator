package com.qyb.qybcustomanimator.util

import android.content.Context
import android.util.DisplayMetrics
import android.util.Log
import android.view.WindowManager

/**
 * Created by Qing Yuanbiao.
 * Created on 2017/12/7.
 * Desc:
 *      获取手机尺寸
 */
object PhoneSize {

    fun getPhoneWidth(context: Context) : Int{
        var wm : WindowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        var metrics = DisplayMetrics()
        wm.defaultDisplay.getMetrics(metrics)
        //Log.i("qyb","宽 ：${metrics.widthPixels}")
        return metrics.widthPixels
    }

    fun getPhoneHeight(context: Context) : Int {
        var wm : WindowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        var metrics = DisplayMetrics()
        wm.defaultDisplay.getMetrics(metrics)
        //Log.i("qyb","高 ：${metrics.heightPixels}")
        return metrics.heightPixels
    }

}