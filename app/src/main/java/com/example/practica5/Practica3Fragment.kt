package com.example.practica5

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment

class Practica3Fragment : Fragment() {
    override fun onCreateView(inflater: android.view.LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val layout = LinearLayout(requireContext())
        layout.orientation = LinearLayout.VERTICAL
        layout.gravity = Gravity.CENTER
        layout.setPadding(16,16,16,16)

        val tv = TextView(requireContext())
        tv.text = "Práctica 3 - Navegación"
        tv.textSize = 22f

        val btn = Button(requireContext())
        btn.text = "Simular navegación"
        val resultado = TextView(requireContext())

        btn.setOnClickListener { resultado.text = "¡Navegación realizada!" }

        layout.addView(tv)
        layout.addView(btn)
        layout.addView(resultado)
        return layout
    }
}
