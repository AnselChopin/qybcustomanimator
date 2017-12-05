package com.qyb.qybcustomanimator.animator

/**
 * Created by Qing Yuanbiao.
 * Created on 2017/12/5.
 * Desc:
 */
interface BaseAnimatior {

    var x : Float
    var y : Float

    fun onObjectEvaluate(fraction: Float, startValue: BaseAnimatior?, endValue: BaseAnimatior?): BaseAnimatior

}