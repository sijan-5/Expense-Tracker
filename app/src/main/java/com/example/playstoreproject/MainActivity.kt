package com.example.playstoreproject

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import com.example.playstoreproject.fragments.HistoryFragment
import com.example.playstoreproject.fragments.HomeFragment
import com.example.playstoreproject.fragments.StatFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.customdialog.view.*

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
            callHomeFragment()
        }

        historyLayout.setOnClickListener {
            callHistoryFragment()
        }

        statLayout.setOnClickListener {

            callStatFragment()
        }


        addItem.setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Manager").setMessage("welcome")

        val view = layoutInflater.inflate(R.layout.customdialog,null)

        builder.setView(view)

        builder.setPositiveButton("ADD",DialogInterface.OnClickListener{ _,_ ->

            val name = view.product_name?.text.toString()
            val price = view.product_price?.text.toString()
            val type = view.product_type?.text.toString()

            when(type)
            {
                "res" ->
                {
                    val intent = Intent(this,Restaurant::class.java)
                    sendData(name,price,type,intent)
                }

                "trans" ->
                {
                    val intent = Intent(this,Transportation::class.java)
                    sendData(name,price,type,intent)
                }

            }



        })
            .setNegativeButton("CANCEL",DialogInterface.OnClickListener{_,_ ->

            })

        builder.show()
    }

    private fun sendData(name:String,price:String,type:String,myIntent: Intent) {
        myIntent.putExtra("name",name)
        myIntent.putExtra("price",price)
        myIntent.putExtra("type",type)
        startActivity(myIntent)
    }


    private fun callStatFragment() {

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

    private fun callHistoryFragment() {
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
    }

    private fun callHomeFragment() {
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


}