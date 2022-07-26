package com.example.playstoreproject

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm,FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int {

        return 2

    }

    override fun getItem(position: Int): Fragment {

        when(position)
        {

            0 -> {
                return loginfragment()
            }

            1->
            {
                return  RegisterFragment()
            }

            else ->
            {
                return loginfragment()
            }

        }


    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position) {
            0 -> {
                return "Login"
            }
            1 -> {
                return "Register"
            }

        }
        return super.getPageTitle(position)
    }
}