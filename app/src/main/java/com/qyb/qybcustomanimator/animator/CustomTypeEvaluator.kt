package com.qyb.qybcustomanimator.animator

import android.animation.TypeEvaluator

/**
 * Created by Administrator.
 * Created on 2017/12/5.
 * Desc:
 */
class CustomTypeEvaluator : TypeEvaluator<BaseAnimatior> {

//    private var customObj : BaseAnimatior
//
//    constructor(customObj : BaseAnimatior){this.customObj = customObj}

    override fun evaluate(fraction: Float, startValue: BaseAnimatior?, endValue: BaseAnimatior?): BaseAnimatior
            = endValue!!.onObjectEvaluate(fraction,startValue,endValue)
}