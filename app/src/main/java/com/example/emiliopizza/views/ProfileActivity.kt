package com.example.emiliopizza.views

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.emiliopizza.R
import com.example.emiliopizza.views.interactors.ProfilePresenterInput
import com.example.emiliopizza.views.interfaces.IProfile
import com.example.emiliopizza.views.models.User
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.squareup.picasso.Picasso

class ProfileActivity: AppCompatActivity(), IProfile.PresenterView {
    lateinit var name: EditText
    lateinit var email: EditText
    lateinit var address: EditText
    lateinit var date: EditText
    lateinit var phone: EditText
    lateinit var btnEdit: FloatingActionButton
    lateinit var btnSave: FloatingActionButton
    lateinit var profilePresenter: ProfilePresenterInput

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)


        init()

        profilePresenter = ProfilePresenterInput(this, this)
        profilePresenter.getDataProfile()

        btnEdit.setOnClickListener {
            btnSave.isEnabled = true
            btnEdit.isEnabled = false
            enableFields()
            //Toast.makeText(applicationContext, "Edit", Toast.LENGTH_SHORT).show()
        }
        btnSave.setOnClickListener {
            btnSave.isEnabled = false
            btnEdit.isEnabled = true
            disenableFields()
            profilePresenter.saveProfileData(
                User(name.text.toString(),email.text.toString(),address.text.toString(),date.text.toString(),phone.text.toString(),))
            Toast.makeText(applicationContext, "Saved", Toast.LENGTH_SHORT).show()
        }
    }

    override fun saveSuccessful(success: Boolean) {
        Toast.makeText(applicationContext, "Saved", Toast.LENGTH_SHORT).show()
    }

    override fun getDataProfile(user: User) {
        name.setText(user.name)
        email.setText(user.email)
        address.setText(user.address)
        date.setText(user.date)
        phone.setText(user.phone)
        Toast.makeText(applicationContext, "${user.name}", Toast.LENGTH_SHORT).show()

    }

    private fun disenableFields(){
        name.isEnabled = false
        email.isEnabled = false
        address.isEnabled = false
        date.isEnabled = false
        phone.isEnabled = false
    }
    private fun enableFields(){
        name.isFocusable = true
        name.isEnabled = true
        email.isEnabled = true
        address.isEnabled = true
        date.isEnabled = true
        phone.isEnabled = true
    }
    private fun init(){
        name = findViewById(R.id.nameUser)
        email = findViewById(R.id.email)
        address = findViewById(R.id.address)
        date = findViewById(R.id.date)
        phone = findViewById(R.id.phone)
        btnEdit = findViewById(R.id.btnEditProfile)
        btnSave= findViewById(R.id.btnSaveProfile)
    }

}