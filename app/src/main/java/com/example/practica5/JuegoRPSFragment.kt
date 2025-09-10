package com.example.practica5

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment

class JuegoRPSFragment : Fragment() {

    private var usuarioScore = 0
    private var dispositivoScore = 0
    private lateinit var tvResultado: TextView
    private lateinit var tvMarcador: TextView

    override fun onCreateView(inflater: android.view.LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val layout = LinearLayout(requireContext())
        layout.orientation = LinearLayout.VERTICAL
        layout.gravity = Gravity.CENTER
        layout.setPadding(16,16,16,16)

        tvResultado = TextView(requireContext())
        tvMarcador = TextView(requireContext()); tvMarcador.text = "Usuario: 0 - Dispositivo: 0"

        val btnPiedra = Button(requireContext()); btnPiedra.text = "Piedra"
        val btnPapel = Button(requireContext()); btnPapel.text = "Papel"
        val btnTijera = Button(requireContext()); btnTijera.text = "Tijera"
        val btnReiniciar = Button(requireContext()); btnReiniciar.text = "Reiniciar marcador"

        val botonesLayout = LinearLayout(requireContext())
        botonesLayout.orientation = LinearLayout.HORIZONTAL
        botonesLayout.gravity = Gravity.CENTER
        botonesLayout.addView(btnPiedra)
        botonesLayout.addView(btnPapel)
        botonesLayout.addView(btnTijera)

        layout.addView(tvResultado)
        layout.addView(tvMarcador)
        layout.addView(botonesLayout)
        layout.addView(btnReiniciar)

        btnPiedra.setOnClickListener { jugar("Piedra") }
        btnPapel.setOnClickListener { jugar("Papel") }
        btnTijera.setOnClickListener { jugar("Tijera") }
        btnReiniciar.setOnClickListener { reiniciar() }

        return layout
    }

    private fun jugar(usuario: String) {
        val opciones = listOf("Piedra","Papel","Tijera")
        val dispositivo = opciones.random()
        val resultado = when {
            usuario == dispositivo -> "Empate"
            usuario=="Piedra" && dispositivo=="Tijera" -> { usuarioScore++; "Ganaste" }
            usuario=="Papel" && dispositivo=="Piedra" -> { usuarioScore++; "Ganaste" }
            usuario=="Tijera" && dispositivo=="Papel" -> { usuarioScore++; "Ganaste" }
            else -> { dispositivoScore++; "Perdiste" }
        }
        tvResultado.text = "Elegiste: $usuario\nDispositivo: $dispositivo\nResultado: $resultado"
        tvMarcador.text = "Usuario: $usuarioScore - Dispositivo: $dispositivoScore"
    }

    private fun reiniciar() {
        usuarioScore = 0
        dispositivoScore = 0
        tvResultado.text=""
        tvMarcador.text="Usuario: 0 - Dispositivo: 0"
    }
}
