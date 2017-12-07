package com.qyb.qybcustomanimator

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import com.qyb.qybcustomanimator.animator.BaseAnimatior
import com.qyb.qybcustomanimator.animator.CubicAnimator
import com.qyb.qybcustomanimator.animator.CustomTypeEvaluator
import com.qyb.qybcustomanimator.util.PhoneSize
import com.qyb.qybcustomanimator.widget.HeartView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mRl : RelativeLayout
    lateinit var circle1: View
    lateinit var circle2: View
    lateinit var heart : HeartView

    var phoneWidth = 0f
    var phoneHeight = 0f
    var centerX = 0f
    var centerY = 0f


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findView()
        initCircle()
        setEvent()
    }

    private fun findView(){
        phoneWidth = PhoneSize.getPhoneWidth(this).toFloat()
        phoneHeight = PhoneSize.getPhoneHeight(this).toFloat()
        centerX = phoneWidth / 2
        centerY = phoneHeight / 2
        mRl = findViewById(R.id.rl_main)
        heart = findViewById(R.id.heart)
        heart.alpha = 0f
    }

    private fun initCircle(){
        circle1 = View(this)
        circle1.translationX = centerX-circle1.width/2
        circle1.translationY = phoneHeight*7/25
        circle1.setBackgroundResource(R.drawable.accent_circle)
        mRl.addView(circle1,RelativeLayout.LayoutParams(60,60))

        circle2 = View(this)
        circle2.translationX = centerX-circle2.width/2
        circle2.translationY = phoneHeight*7/25
        circle2.setBackgroundResource(R.drawable.accent_circle)
        mRl.addView(circle2,RelativeLayout.LayoutParams(60,60))
    }

    private fun setEvent(){
        btn_main.setOnClickListener { playAnimator() }
    }

    private fun playAnimator(){
        var circle1Anima = ValueAnimator.ofObject(CustomTypeEvaluator(),
                CubicAnimator(centerX- circle1.width/2, phoneHeight*7/25),//设置起点
                //动画路径
                CubicAnimator(phoneWidth*409/600, phoneHeight*69/500,
                        phoneWidth*538/600, phoneHeight*222/500,
                        centerX- circle1.width/2, phoneHeight*7/10),
                CubicAnimator(centerX- circle1.width/2, phoneHeight*7/25,
                        centerX- circle1.width/2, phoneHeight*7/25,
                        centerX- circle1.width/2, phoneHeight*7/25)
         ).apply {
            addUpdateListener(object : ValueAnimator.AnimatorUpdateListener{
                override fun onAnimationUpdate(animation: ValueAnimator?) {
                    var value : BaseAnimatior = animation?.animatedValue as BaseAnimatior
                    circle1.translationX = value.x
                    circle1.translationY = value.y
                }
            })
        }

        var circle2Anima = ValueAnimator.ofObject(CustomTypeEvaluator(),
                CubicAnimator(centerX- circle2.width/2, phoneHeight*7/25),//设置起点
                CubicAnimator(
                        phoneWidth-phoneWidth*409/600,phoneHeight*69/500,
                        phoneWidth-phoneWidth*538/600,phoneHeight*222/500,

                        centerX- circle2.width/2, phoneHeight*7/10),
                CubicAnimator(centerX- circle2.width/2, phoneHeight*7/25,
                        centerX- circle2.width/2, phoneHeight*7/25,
                        centerX- circle2.width/2, phoneHeight*7/25)
        ).apply {
            addUpdateListener(object : ValueAnimator.AnimatorUpdateListener{
                override fun onAnimationUpdate(animation: ValueAnimator?) {
                    var value : BaseAnimatior = animation?.animatedValue as BaseAnimatior
                    circle2.translationX = value.x
                    circle2.translationY = value.y
                }
            })
        }

        var circle1Alpha = ObjectAnimator.ofFloat(circle1,"alpha",1f,0f)
        var circle2Alpha = ObjectAnimator.ofFloat(circle2,"alpha",1f,0f)
        var heartAlpha = ObjectAnimator.ofFloat(heart,"alpha",0f,1f)
        var heartRotate = ObjectAnimator.ofFloat(heart,"rotationY",0f,180f,0f)

        AnimatorSet().apply {
            play(circle1Anima).with(circle2Anima).with(circle1Alpha).with(circle2Alpha)
                    .before(heartAlpha)
                    .before(heartRotate)
            duration = 3_000L
        }.start()

    }

}
