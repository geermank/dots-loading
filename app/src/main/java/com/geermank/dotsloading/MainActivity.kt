package com.geermank.dotsloading

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), MenuFragment.MenuFragmentListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, MenuFragment())
                .commit()
    }

    override fun showDynamicLoading() {
        replaceFragment(DynamicLoadingFragment())
    }

    override fun showCircularProgress() {
        replaceFragment(CircularProgressFragment())
    }

    override fun showOrbitProgress() {
        replaceFragment(OrbitProgressFragment())
    }

    override fun showLinearProgress() {
        replaceFragment(LinearProgressFragment())
    }

    override fun showBounceProgress() {
        replaceFragment(BounceProgressFragment())
    }

    override fun showTikTokProgress() {
        replaceFragment(TikTokDotLoadingFragment())
    }

    private fun replaceFragment(newFragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, newFragment)
                .addToBackStack(null)
                .commit()
    }
}