package com.example.playstoreproject

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.fragment_loginfragment.*

class LoginActivity : AppCompatActivity(),RegisterFragment.SlideMe {

    lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        vpager.adapter = PageAdapter(supportFragmentManager)
        tabLayout.setupWithViewPager(vpager)


        tabLayout.translationX = 500f
        tabLayout.alpha = 0f

        tabLayout.animate().alpha(1f).translationX(0f).duration = 1000


    }

    override fun slideMethod() {
        startActivity(Intent(this,MainActivity::class.java))
        overridePendingTransition(R.anim.right_in,R.anim.left_out)
    }



    override fun onStart() {
        super.onStart()

        auth = Firebase.auth
        val currentUser = auth.currentUser
        if(currentUser!=null)
        {
            startActivity(Intent(this,MainActivity::class.java))
        }

    }



}