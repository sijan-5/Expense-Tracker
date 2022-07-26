package com.example.playstoreproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_loginfragment.*




class loginfragment : Fragment() {

    private lateinit var auth :FirebaseAuth


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view: View =  inflater.inflate(R.layout.fragment_loginfragment, container, false)
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        inputemail?.translationX = 500f
        inputPassword?.translationX = 500f
        forgotPassoword?.translationX = 500f
        loginbutton?.translationX = 500f

        forgotPassoword?.alpha = 0f
        loginbutton?.alpha = 0f
        inputPassword?.alpha = 0f
        inputemail?.alpha = 0f

        inputemail.animate().alpha(1f).translationX(0f).setDuration(800).startDelay = 300
        inputPassword.animate().alpha(1f).translationX(0f).setDuration(800).startDelay = 500
        forgotPassoword.animate().alpha(1f).translationX(0f).setDuration(800).startDelay = 500
        loginbutton.animate().alpha(1f).translationX(0f).setDuration(800).startDelay = 700

    }


}