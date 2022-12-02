package com.example.compshop.rubrosFragments

import adaptadores.MecanicosAdaptador
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.compshop.DetallesMecanicoActivity
import com.example.compshop.databinding.ActivityMecanicosBinding
import modelos.Servicio
import viewModels.ServicioViewModel

class MecanicosActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMecanicosBinding
    private lateinit var adaptador: MecanicosAdaptador
    private val viewModel by lazy { ViewModelProvider(this).get(ServicioViewModel::class.java) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMecanicosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
            binding.recyclerviewMecanicos.layoutManager = LinearLayoutManager(this)
            binding.recyclerviewMecanicos.adapter = adaptador
        val nombre = intent.getStringExtra("nombre")
        observeData(nombre!!)
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        return super.onCreateView(name, context, attrs)
        initRecyclerView()
    }

    private fun observeData(nombreObserver: String){
        var filtroServicioList = mutableListOf<Servicio>()
        viewModel.fetchUserData(nombreObserver).observe(this, Observer {
            for (mecanico in it){
                if (mecanico.precioServicio != 0){
                    filtroServicioList.add(mecanico)
                }
            }

           adaptador.setListData(filtroServicioList)
            adaptador.notifyDataSetChanged()
        })
    }
    fun initRecyclerView(){
        binding.recyclerviewMecanicos.layoutManager = LinearLayoutManager(this)
        adaptador = MecanicosAdaptador(this){ servicio ->
            onItemSelected(
                servicio
            )
        }
    }
    private fun onItemSelected(servicio: Servicio){
        val intent = Intent(this,DetallesMecanicoActivity::class.java)
        intent.putExtra("nombre", servicio.nombreMecanico)
        startActivity(intent)
    }
}