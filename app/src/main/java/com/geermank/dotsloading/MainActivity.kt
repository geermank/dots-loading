package com.geermank.dotsloading

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), MenuFragment.MenuFragmentListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, MenuFragment())
                .commit()
    }

    override fun showCircularProgress() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, CircularProgressFragment())
                .addToBackStack(null)
                .commit()
    }

    override fun showOrbitProgress() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, OrbitProgressFragment())
                .addToBackStack(null)
                .commit()
    }

    override fun showLinearProgress() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, LinearProgressFragment())
                .addToBackStack(null)
                .commit()
    }

    override fun showBounceLoading() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, BounceProgressFragment())
                .addToBackStack(null)
                .commit()
    }
}