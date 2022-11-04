package com.example.compshop

import adaptadores.AdaptadorRubro
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import modelos.RubroProviderPrueba

class Cotiza : AppCompatActivity() {

    var boton : Button?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cotiza)
        initRecyclerView()
//        boton = findViewById(R.id.button8)
//
//        boton!!.setOnClickListener()
//        {
//            startActivity(Intent(this, MainActivity::class.java))
//
//        }
    }
    fun initRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview_rubro)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = AdaptadorRubro(RubroProviderPrueba.rubroList)
    }
}