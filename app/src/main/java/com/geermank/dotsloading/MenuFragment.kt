package com.geermank.dotsloading

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton

class MenuFragment : Fragment() {

    interface MenuFragmentListener {
        fun showCircularProgress()
        fun showOrbitProgress()
        fun showLinearProgress()
        fun showBounceProgress()
        fun showTikTokProgress()
    }

    private lateinit var listener: MenuFragmentListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as MenuFragmentListener
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<MaterialButton>(R.id.circular_progress).apply {
            setOnClickListener { listener.showCircularProgress() }
        }

        view.findViewById<MaterialButton>(R.id.orbit_progress).apply {
            setOnClickListener { listener.showOrbitProgress() }
        }

        view.findViewById<MaterialButton>(R.id.linear_progress).apply {
            setOnClickListener { listener.showLinearProgress() }
        }

        view.findViewById<MaterialButton>(R.id.bouncing_progress).apply {
            setOnClickListener { listener.showBounceProgress() }
        }

        view.findViewById<MaterialButton>(R.id.tik_tok_progress).apply {
            setOnClickListener { listener.showTikTokProgress() }
        }
    }
}
