package com.example.compshop


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit

import com.example.compshop.rubrosFragments.RubroFragment


class MainActivity : AppCompatActivity() {

    var boton : Button?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        boton = findViewById(R.id.button_cotizar)

        boton!!.setOnClickListener()
        {
            startActivity(Intent(this, Cotiza::class.java))

        }

    }
}


