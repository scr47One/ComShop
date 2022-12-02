package com.example.compshop

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.compshop.databinding.ActivityDetallesMecanicoBinding
import viewModels.MecanicoViewModel

class DetallesMecanicoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetallesMecanicoBinding
    private val viewModel by lazy { ViewModelProvider(this).get(MecanicoViewModel::class.java) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetallesMecanicoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val nombre = intent.getStringExtra("nombre")
        Log.e("nombre",nombre.toString())
        observeData(nombre!!.toString())
    }
    @SuppressLint("SetTextI18n")
    private fun observeData(nombreObserver: String){
        viewModel.fetchUserData().observe(this) {
            it.forEach { mecanico ->
                if(mecanico.nombre.equals(nombreObserver)){
                    binding.nombreMecanico.text = mecanico.nombre
                    Glide.with(binding.imgUser.context).load(mecanico.imagen).into(binding.imagen)
                    binding.telefono.text = mecanico.telefono
                    binding.aceite.text = "$${mecanico.aceite}"
                    binding.afinacion.text = "$${mecanico.afinacion}"
                    binding.alfombra.text = "$${mecanico.alfombra}"
                    binding.amortiguadores.text = "$${mecanico.amortiguadores}"
                    binding.asientos.text = "$${mecanico.asientos}"
                    binding.pulido.text = "$${mecanico.pulido}"
                    binding.empastado.text = "$${mecanico.empastado}"
                    binding.encerado.text = "$${mecanico.encerado}"
                    binding.alineacion.text = "$${mecanico.alineacion}"
                    binding.balanceo.text = "$${mecanico.balanceo}"
                    binding.bandas.text = "$${mecanico.bandas}"
                }
            }
        }
    }
}