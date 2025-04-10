package com.example.crud_prueba

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


import com.example.crud_prueba.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        databaseHelper = DatabaseHelper(this)

        binding.signupBtn.setOnClickListener{
            val signupNombre = binding.signupNombre.text.toString()
            val signupCedula = binding.signupCedula.text.toString()
            val signupPassword = binding.signupPassword.text.toString()

            signupDatabase(signupNombre,signupCedula,signupPassword)
        }
        }

    private fun signupDatabase(nombre: String, cedula: String, password:String){
        val insertRowId = databaseHelper.inserUser(nombre, cedula, password)
        if (insertRowId != -1L) {
            Toast.makeText(this, "Signup Successful", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Signup Failed", Toast.LENGTH_SHORT).show()
        }
    }
}