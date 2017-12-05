package com.qyb.qybcustomanimator.animator

/**
 * Created by Qing Yuanbiao.
 * Created on 2017/12/5.
 * Desc:
 *      所有自定义动画都实现这个接口，具体实现细节将回调到具体自定义动画中
 *
 *
 */
interface BaseAnimatior {

    var x : Float
    var y : Float

    fun onObjectEvaluate(fraction: Float, startValue: BaseAnimatior?, endValue: BaseAnimatior?): BaseAnimatior

}