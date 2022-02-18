package com.example.emiliopizza.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import com.example.emiliopizza.R
import com.example.emiliopizza.views.interactors.LoginPresenterInput
import com.example.emiliopizza.views.interfaces.ILogingView
import com.example.emiliopizza.views.models.Model
import com.example.emiliopizza.views.models.User
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity(), ILogingView {
    lateinit var email: EditText
    lateinit var password:EditText
    lateinit var btnLogin: Button
    lateinit var model: Model
    lateinit var presenterInput: LoginPresenterInput

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()

        model = Model()
        presenterInput = LoginPresenterInput(this, model)

        btnLogin.setOnClickListener {
            lifecycleScope.launch {
                presenterInput.login()
            }
        }
    }
    private fun init(){
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        btnLogin = findViewById(R.id.btnlogin)
    }
    override fun loging(user: User) {
        Intent(this, MainActivity::class.java).apply {
            startActivity(this)
            finish()
        }
    }
}