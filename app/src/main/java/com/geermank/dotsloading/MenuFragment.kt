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
        fun showDynamicLoading()
        fun showCircularLoading()
        fun showOrbitLoading()
        fun showLinearLoading()
        fun showBounceLoading()
        fun showTikTokLoading()
        fun showFlipLoading()
        fun showScaleLoading()
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
        view.findViewById<MaterialButton>(R.id.dynamic_loading).apply {
            setOnClickListener { listener.showDynamicLoading() }
        }

        view.findViewById<MaterialButton>(R.id.circular_progress).apply {
            setOnClickListener { listener.showCircularLoading() }
        }

        view.findViewById<MaterialButton>(R.id.orbit_progress).apply {
            setOnClickListener { listener.showOrbitLoading() }
        }

        view.findViewById<MaterialButton>(R.id.linear_progress).apply {
            setOnClickListener { listener.showLinearLoading() }
        }

        view.findViewById<MaterialButton>(R.id.bouncing_progress).apply {
            setOnClickListener { listener.showBounceLoading() }
        }

        view.findViewById<MaterialButton>(R.id.tik_tok_progress).apply {
            setOnClickListener { listener.showTikTokLoading() }
        }

        view.findViewById<MaterialButton>(R.id.flip_progress).apply {
            setOnClickListener { listener.showFlipLoading() }
        }

        view.findViewById<MaterialButton>(R.id.scale_progress).apply {
            setOnClickListener { listener.showScaleLoading() }
        }
    }
}
