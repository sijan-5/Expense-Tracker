package com.example.playstoreproject

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_splash.*

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        backview.animate().translationY(-2500f).setDuration(4000).startDelay = 2000

        lottie.animate().translationY(2500f).setDuration(1500).startDelay = 3000




        val handler = Handler()
        handler.postDelayed({
            text.setTextColor(ContextCompat.getColor(applicationContext,R.color.white))
        },1000)

        handler.postDelayed({
            startActivity(Intent(this, LoginActivity::class.java))

            overridePendingTransition(R.anim.right_in, R.anim.left_out)
        }, 6000)

    }

    override fun onStart() {
        super.onStart()
        text.animate().translationY(-1250f).setDuration(1300).startDelay = 1000
    }

}