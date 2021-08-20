package com.geermank.dotsloading

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.EditText
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatSpinner
import androidx.fragment.app.Fragment
import com.geermank.dots.extensions.generateNewId
import com.geermank.dots.loading.view.DotLoading
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView

class DynamicLoadingFragment : Fragment() {

    private lateinit var loadingTypesSpinner: AppCompatSpinner
    private lateinit var loadingSizeSpinner: AppCompatSpinner
    private lateinit var numberOfDotsInput: EditText

    private lateinit var configContainer: MaterialCardView
    private lateinit var showLoadingButton: MaterialButton
    private lateinit var hideLoadingButton: MaterialButton

    private var loadingId: Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_dynamic_loading, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        loadingTypesSpinner = view.findViewById(R.id.loading_types_spinner)
        loadingSizeSpinner = view.findViewById(R.id.loading_size_spinner)
        numberOfDotsInput = view.findViewById(R.id.et_number_of_dots)
        configContainer = view.findViewById(R.id.cv_config_container)

        showLoadingButton = view.findViewById(R.id.btn_show_loading)
        hideLoadingButton = view.findViewById(R.id.btn_hide_loading)

        showLoadingButton.setOnClickListener {
            createLoadingBasedOnUserSpecs()
        }

        hideLoadingButton.setOnClickListener {
            removeLoadingAndShowConfig()
        }
    }

    private fun createLoadingBasedOnUserSpecs() {
        val dotLoading = DotLoading.Builder(requireContext())
                .setLoadingType(loadingTypesSpinner.selectedItemPosition)
                .setLoadingSize(loadingSizeSpinner.selectedItemPosition)
                .setNumberOfDots(numberOfDotsInput.text.toString().toInt())
                .build()
        centerView(dotLoading)
        loadingId = dotLoading.id

        hideConfigContainer()

        (view as? ViewGroup)?.addView(dotLoading)
    }

    private fun removeLoadingAndShowConfig() {
        view?.findViewById<DotLoading>(loadingId)?.let {
            (view as ViewGroup).removeView(it)
            showConfigContainer()
        }
    }

    private fun centerView(dotLoading: DotLoading) {
        dotLoading.layoutParams = FrameLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT).also {
            it.gravity = Gravity.CENTER
        }
    }

    private fun hideConfigContainer() {
        configContainer.visibility = View.GONE
        hideLoadingButton.visibility = View.VISIBLE
    }

    private fun showConfigContainer() {
        configContainer.visibility = View.VISIBLE
        hideLoadingButton.visibility = View.GONE
    }
}
