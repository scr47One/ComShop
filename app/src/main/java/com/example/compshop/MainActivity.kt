package com.example.compshop


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.example.compshop.databinding.ActivityMainBinding
import com.example.compshop.databinding.ActivityMecanicosBinding

import com.example.compshop.rubrosFragments.RubroFragment


class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.cotizaCard.setOnClickListener{
            startActivity(Intent(this, Cotiza::class.java))
        }
        binding.quienesSomosCard.setOnClickListener{

            startActivity(Intent(this, QuienesSomos::class.java))
        }

    }
}


