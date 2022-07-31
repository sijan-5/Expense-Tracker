package com.example.playstoreproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_restaurant.*
import kotlinx.android.synthetic.main.activity_restaurant.viewFirst
import kotlinx.android.synthetic.main.activity_restaurant.viewSecond
import kotlinx.android.synthetic.main.activity_restaurant.viewThird
import kotlinx.android.synthetic.main.activity_transportation.*

class Transportation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transportation)

        val bundle : Bundle ? = intent.extras
        val name  = bundle!!.getString("name")
        val price = bundle.getString("price")
        val type = bundle.getString("type")
        tviewFirst?.text = name
        tviewSecond?.text =  price
       // tviewThird?.text = type
    }
}