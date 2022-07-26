package com.example.playstoreproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import com.example.playstoreproject.fragments.HistoryFragment
import com.example.playstoreproject.fragments.HomeFragment
import com.example.playstoreproject.fragments.StatFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var selectedTab: Int = 1
    var homefragment = HomeFragment()
    var historyFragment = HistoryFragment()
    var statFragment = StatFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportFragmentManager.beginTransaction().apply {
            replace(R.id.mainFrame, homefragment).addToBackStack(null).commit()
        }



        homelayout.setOnClickListener {

            if (selectedTab != 1) {
                historyText.visibility = View.INVISIBLE
                statText.visibility = View.INVISIBLE

                histroyImage.setImageResource(R.drawable.blackhistory)
                statImage.setImageResource(R.drawable.blackstat)

                historyLayout.setBackgroundColor(resources.getColor(android.R.color.transparent))
                statLayout.setBackgroundColor(resources.getColor(android.R.color.transparent))

                hometext.visibility = View.VISIBLE
                homeImage.setImageResource(R.drawable.ic_home)
                homelayout.setBackgroundResource(R.drawable.formynavi)


                val scaleAnimation: ScaleAnimation = ScaleAnimation(0.8f, 1.0f, 1f, 1f,
                    Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f)

                scaleAnimation.duration = 200
                scaleAnimation.fillAfter = true
                homelayout.startAnimation(scaleAnimation)




                supportFragmentManager.beginTransaction()
                    .setCustomAnimations(R.anim.left_in, R.anim.right_out).apply {
                    replace(R.id.mainFrame, homefragment).addToBackStack(null).commit()
                }

                selectedTab = 1
            }

        }

        historyLayout.setOnClickListener {

            if (selectedTab != 2) {
                hometext.visibility = View.INVISIBLE
                statText.visibility = View.INVISIBLE

                homeImage.setImageResource(R.drawable.blackhome)
                statImage.setImageResource(R.drawable.blackstat)

                homelayout.setBackgroundColor(resources.getColor(android.R.color.transparent))
                statLayout.setBackgroundColor(resources.getColor(android.R.color.transparent))

                historyText.visibility = View.VISIBLE
                histroyImage.setImageResource(R.drawable.history)
                historyLayout.setBackgroundResource(R.drawable.formynavi)

                val scaleAnimation: ScaleAnimation = ScaleAnimation(0.8f, 1.0f, 1f, 1f,
                    Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f)

                scaleAnimation.duration = 200
                scaleAnimation.fillAfter = true
                historyLayout.startAnimation(scaleAnimation)

                if (selectedTab == 3) {

                    supportFragmentManager.beginTransaction()
                        .setCustomAnimations(R.anim.left_in, R.anim.right_out).apply {
                        replace(R.id.mainFrame, historyFragment).addToBackStack(null).commit()
                    }

                } else {
                    supportFragmentManager.beginTransaction()
                        .setCustomAnimations(R.anim.right_in, R.anim.left_out).apply {
                        replace(R.id.mainFrame, historyFragment).addToBackStack(null).commit()
                    }
                }
                selectedTab = 2
            }

            statLayout.setOnClickListener {

                if (selectedTab != 3) {
                    historyText.visibility = View.INVISIBLE
                    hometext.visibility = View.INVISIBLE

                    histroyImage.setImageResource(R.drawable.blackhistory)
                    homeImage.setImageResource(R.drawable.blackhome)

                    historyLayout.setBackgroundColor(resources.getColor(android.R.color.transparent))
                    homelayout.setBackgroundColor(resources.getColor(android.R.color.transparent))

                    statText.visibility = View.VISIBLE
                    statImage.setImageResource(R.drawable.statistics)
                    statLayout.setBackgroundResource(R.drawable.formynavi)


                    val scaleAnimation = ScaleAnimation(0.8f, 1.0f, 1f, 1f,
                        Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.0f)

                    scaleAnimation.duration = 200
                    scaleAnimation.fillAfter = true
                    statLayout.startAnimation(scaleAnimation)

                    supportFragmentManager.beginTransaction()
                        .setCustomAnimations(R.anim.right_in, R.anim.left_out).apply {
                        replace(R.id.mainFrame, statFragment).addToBackStack(null).commit()
                    }
                    selectedTab = 3
                }

            }
        }
    }
}