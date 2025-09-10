package com.example.practica5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment

class Practica4Fragment : Fragment() {

    private lateinit var etNombre: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnEnviar: Button
    private lateinit var btnLimpiar: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val layout = inflater.inflate(R.layout.fragment_practica4, container, false)

        etNombre = layout.findViewById(R.id.etNombre)
        etEmail = layout.findViewById(R.id.etEmail)
        etPassword = layout.findViewById(R.id.etPassword)
        btnEnviar = layout.findViewById(R.id.btnEnviar)
        btnLimpiar = layout.findViewById(R.id.btnLimpiar)

        btnEnviar.setOnClickListener { validarFormulario() }
        btnLimpiar.setOnClickListener { limpiarFormulario() }

        return layout
    }

    private fun validarFormulario() {
        val nombre = etNombre.text.toString().trim()
        val email = etEmail.text.toString().trim()
        val password = etPassword.text.toString().trim()

        when {
            nombre.length < 3 -> etNombre.error = "Nombre mínimo 3 caracteres"
            !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() -> etEmail.error = "Email inválido"
            password.length < 6 -> etPassword.error = "Contraseña mínimo 6 caracteres"
            else -> Toast.makeText(requireContext(), "Registrado: $nombre ($email)", Toast.LENGTH_LONG).show()
        }
    }

    private fun limpiarFormulario() {
        etNombre.text.clear()
        etEmail.text.clear()
        etPassword.text.clear()
        etNombre.error = null
        etEmail.error = null
        etPassword.error = null
    }
}
