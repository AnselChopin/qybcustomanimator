package com.qyb.qybcustomanimator

import android.animation.ValueAnimator
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import com.qyb.qybcustomanimator.animator.BaseAnimatior
import com.qyb.qybcustomanimator.animator.CubicAnimator
import com.qyb.qybcustomanimator.animator.CustomTypeEvaluator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mRl : RelativeLayout
    lateinit var blueCircle : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findView()
        initCircle()
        setEvent()
    }

    private fun findView(){
        mRl = findViewById(R.id.rl_main)
    }

    private fun initCircle(){
        blueCircle = View(this)
        blueCircle.translationX = 100f
        blueCircle.translationY = 435f
        blueCircle.setBackgroundResource(R.drawable.accent_circle)
        mRl.addView(blueCircle,RelativeLayout.LayoutParams(60,60))
    }

    private fun setEvent(){
        btn_main.setOnClickListener { playAnimator() }
    }

    private fun playAnimator(){
        ValueAnimator.ofObject(CustomTypeEvaluator(),
                CubicAnimator(100f,435f),//设置起点
                CubicAnimator(150f, 100f, 350f, 100f, 431f, 435f),//动画路径
                CubicAnimator(150f, 100f, 350f, 100f, 526f, 273f)//动画路径
         ).apply {
            duration = 2_500L
            repeatCount = 1
            repeatMode = ValueAnimator.REVERSE
            addUpdateListener(object : ValueAnimator.AnimatorUpdateListener{
                override fun onAnimationUpdate(animation: ValueAnimator?) {
                    var value : BaseAnimatior = animation?.animatedValue as BaseAnimatior
                    blueCircle.translationX = value.x
                    blueCircle.translationY = value.y
                }
            })
        }.start()

    }

}
