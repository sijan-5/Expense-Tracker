package com.example.playstoreproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_restaurant.*

class Restaurant : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant)


        val bundle : Bundle ? = intent.extras
        val name  = bundle!!.getString("name")
        val price = bundle.getString("price")
        val type = bundle.getString("type")
        viewFirst?.text = name
        viewSecond?.text =  price
        viewThird?.text = type
    }

//    override fun onPositiveSendData(nam: String, pric: String, typ: String) {
//        viewFirst.text = nam
//        viewSecond.text = pric
//        viewThird.text = typ
//    }
}