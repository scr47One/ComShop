package com.example.compshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Cotiza : AppCompatActivity() {

    var boton : Button?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cotiza)

        boton = findViewById(R.id.button8)

        boton!!.setOnClickListener()
        {
            startActivity(Intent(this, MainActivity::class.java))

        }
    }
}