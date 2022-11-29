package com.example.compshop.rubrosFragments

import adaptadores.MecanicosAdaptador
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.compshop.R
import com.example.compshop.databinding.ActivityMecanicosBinding
import modelos.Mecanico
import viewModels.MecanicosViewModel

class MecanicosActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMecanicosBinding
    private lateinit var adaptador: MecanicosAdaptador
    private val viewModel by lazy { ViewModelProvider(this).get(MecanicosViewModel::class.java) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMecanicosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adaptador = MecanicosAdaptador(this)
            binding.recyclerviewMecanicos.layoutManager = LinearLayoutManager(this)
            binding.recyclerviewMecanicos.adapter = adaptador
        val nombre = intent.getStringExtra("nombre")
        Log.e("ADAPTADOR",nombre!!)
        observeData(nombre!!)
    }
    fun observeData(nombreObserver: String){
        viewModel.fetchUserData(nombreObserver).observe(this, Observer {
           adaptador.setListData(it)
        })
    }
}