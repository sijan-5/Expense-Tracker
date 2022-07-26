package com.example.playstoreproject

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.transition.Slide
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_registerfragment.*


class RegisterFragment: Fragment() {

    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_registerfragment, container, false)
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rbutton.setOnClickListener {
            when {

                TextUtils.isEmpty(email.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(activity, "Please enter email address", Toast.LENGTH_LONG).show()
                }

                TextUtils.isEmpty(password.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(activity, "Please enter password", Toast.LENGTH_LONG).show()
                }

                TextUtils.isEmpty(username.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(activity, "Please enter your UserName", Toast.LENGTH_LONG).show()
                }

                TextUtils.isEmpty(confirmpassword.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(activity, "Please confirm your password", Toast.LENGTH_LONG)
                        .show()
                }

                else -> {
                    val userName = username.text.toString().trim()
                    val registerEmail = email.text.toString().trim()
                    val registerPassword = password.text.toString().trim()
                    val confirmPassword = confirmpassword.text.toString().trim()

                    auth = Firebase.auth

                    auth.createUserWithEmailAndPassword(registerEmail, registerPassword)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                // Sign in success, update UI with the signed-in user's information

                                Toast.makeText(activity, "Authentication success.",
                                    Toast.LENGTH_SHORT).show()

                                savingInformation(userName, registerEmail, registerPassword)

                                (activity as LoginActivity).slideMethod()


                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "createUserWithEmail:failure", task.exception)
                                Toast.makeText(activity, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show()

                            }
                        }
                }
            }
        }
    }
//            startActivity(Intent(activity, MainActivity::class.java))
////            (activity as LoginActivity).slideMethod()
//        }
//    }

        //saving userdata into the firebase database

        private fun savingInformation(
            userName: String,
            registerEmail: String,
            registerPassword: String
        ) {

            database = FirebaseDatabase.getInstance().reference

            val dataClassObject = UserInformation(userName, registerEmail, registerPassword)
            database.child("Sijan's Client").child(auth.currentUser!!.uid).setValue(dataClassObject)
                .addOnCompleteListener {

                }
        }

        interface SlideMe {
            fun slideMethod()
        }


    }

