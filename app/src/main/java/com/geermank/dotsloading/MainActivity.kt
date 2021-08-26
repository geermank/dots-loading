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

    override fun showCircularLoading() {
        replaceFragment(CircularProgressFragment())
    }

    override fun showOrbitLoading() {
        replaceFragment(OrbitProgressFragment())
    }

    override fun showLinearLoading() {
        replaceFragment(LinearProgressFragment())
    }

    override fun showBounceLoading() {
        replaceFragment(BounceProgressFragment())
    }

    override fun showTikTokLoading() {
        replaceFragment(TikTokDotLoadingFragment())
    }

    override fun showFlipLoading() {
        replaceFragment(FlipProgressFragment())
    }

    override fun showScaleLoading() {
        replaceFragment(ScaleLoadingFragment())
    }

    private fun replaceFragment(newFragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, newFragment)
                .addToBackStack(null)
                .commit()
    }
}