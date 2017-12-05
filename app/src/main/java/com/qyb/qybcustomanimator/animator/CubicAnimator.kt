package com.qyb.qybcustomanimator.animator

/**
 * Created by Qing Yuanbiao
 * Created on 2017/12/5.
 * Desc:
 *      三阶贝塞尔曲线
 */
class CubicAnimator : BaseAnimatior {

    override var x: Float = 0f
    override var y: Float = 0f

    var startX = 0f
    var startY = 0f

    var controlX1 = 0f
    var controlY1 = 0f

    var controlX2 = 0f
    var controlY2 = 0f

    var endX = 0f
    var endY = 0f

    constructor(x: Float,y: Float){
        this.x = x
        this.y = y
    }

    constructor(controlX1:Float,controlY1:Float,controlX2:Float,controlY2:Float,endX:Float,endY:Float){
        this.controlX1 = controlX1
        this.controlY1 = controlY1
        this.controlX2 = controlX2
        this.controlY2 = controlY2
        this.endX = endX
        this.endY = endY
    }

    override fun onObjectEvaluate(fraction: Float, startValue: BaseAnimatior?, endValue: BaseAnimatior?): BaseAnimatior {
        startX = startValue?.x ?: 0f
        startY = startValue?.y ?: 0f

        //贝塞尔曲线三阶公式
        var temp = 1 - fraction
        x = startX * temp *temp *temp + 3 * this.controlX1 * fraction * temp * temp +
                3 * this.controlX2 * fraction * fraction * temp + endX * fraction * fraction *fraction
        y = startY * temp *temp *temp + 3 * this.controlY1 * fraction * temp * temp +
                3 * this.controlY2 * fraction * fraction * temp + endY * fraction * fraction *fraction

        return CubicAnimator(x,y)
    }
}