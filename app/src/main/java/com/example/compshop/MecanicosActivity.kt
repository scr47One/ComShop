package com.example.compshop

import adaptadores.MecanicosAdaptador
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.compshop.databinding.ActivityMecanicosBinding
import modelos.Servicio
import viewModels.ServicioViewModel

class MecanicosActivity : AppCompatActivity() {
    private lateinit var nombre: String
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
        nombre = intent.getStringExtra("nombre").toString()
        observeData(nombre)
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        return super.onCreateView(name, context, attrs)
        initRecyclerView()
    }

    private fun observeData(nombreObserver: String?){
        var filtroServicioList = mutableListOf<Servicio>()
        viewModel.fetchUserData(nombreObserver).observe(this, Observer {
            for (mecanico in it){
                if (mecanico.precioServicio != 0){

                    filtroServicioList.add(mecanico)
                }
            }
            datosAdaptador(filtroServicioList)
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detalles_mecanico,menu)

        return true
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun datosAdaptador(listaServicio: MutableList<Servicio>){
        adaptador.setListData(listaServicio)
        adaptador.notifyDataSetChanged()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.precio_ascendente ->  {ordenAscendente(nombre)}
            R.id.precio_descendente ->  {ordenDescendente(nombre)}
        }
        return super.onOptionsItemSelected(item)
    }

    private fun ordenDescendente(nombreObserver: String?) {
        var servicioList = mutableListOf<Servicio>()
        var filtroServicioList = mutableListOf<Servicio>()
        viewModel.fetchUserData(nombreObserver).observe(this, Observer {
            for (mecanico in it){
                if (mecanico.precioServicio != 0){

                    filtroServicioList.add(mecanico)
                }
            }
            filtroServicioList.sortedByDescending { servicio ->  servicio.precioServicio}.forEach { servicio ->
                servicioList.add(servicio)
            }
            datosAdaptador(servicioList)
        })
        datosAdaptador(servicioList)
    }

    private fun ordenAscendente(nombreObserver: String?) {
        var servicioList = mutableListOf<Servicio>()
        var filtroServicioList = mutableListOf<Servicio>()
        viewModel.fetchUserData(nombreObserver).observe(this, Observer {
            for (mecanico in it){
                if (mecanico.precioServicio != 0){

                    filtroServicioList.add(mecanico)
                }
            }
            filtroServicioList.sortedBy { servicio ->  servicio.precioServicio}.forEach { servicio ->
                servicioList.add(servicio)
            }
            datosAdaptador(servicioList)
        })
        datosAdaptador(servicioList)
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