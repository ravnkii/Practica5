package com.example.practica5

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class Practica1Fragment : Fragment() {
    override fun onCreateView(inflater: android.view.LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val tv = TextView(requireContext())
        tv.text = "¡Hola Mundo! - Práctica 5"
        tv.textSize = 24f
        tv.gravity = Gravity.CENTER
        return tv
    }
}
