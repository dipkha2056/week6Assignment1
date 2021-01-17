package com.deependra.week6assignmrent1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var etUserName : EditText
    private lateinit var etPassword : EditText
    private lateinit var btnLogin : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etUserName = findViewById(R.id.etUserName)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val username = etUserName.text.toString()
            val password = etPassword.text.toString()

            if (username == "softwarica" && password == "coventry"){
                val intent = Intent(this,buttomNavActivity::class.java)
                startActivity(intent)
            }
            else if (username!= "softwarica"){
                etUserName.error = "please enter valid Username"
                etUserName.requestFocus()
                //Toast.makeText(this, "please enter valid UserName", Toast.LENGTH_SHORT).show()
            }
            else{
                etPassword.error = "please check your Password"
                etPassword.requestFocus()
                //Toast.makeText(this, "check your password", Toast.LENGTH_SHORT).show()
            }

        }
    }
}