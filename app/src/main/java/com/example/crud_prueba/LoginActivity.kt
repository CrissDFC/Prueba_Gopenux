package com.example.crud_prueba

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.crud_prueba.databinding.ActivityLogin2Binding


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLogin2Binding
    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogin2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        databaseHelper = DatabaseHelper(this)

        binding.loginBtn.setOnClickListener{
            val loginUsername = binding.cedula.text.toString()
            val loginPassword = binding.password.text.toString()
            loginDatabase(loginUsername, loginPassword)

        }

    }
    private fun loginDatabase(cedula: String, password: String) {
        val userExists = databaseHelper.readUser(cedula, password)

        if (userExists) {
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
            return
        }
        Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()

    }
}