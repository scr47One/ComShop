package com.example.compshop.rubrosFragments

import adaptadores.AdaptadorHojalateria
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.compshop.R
import com.example.compshop.databinding.FragmentHojalateriaBinding
import com.example.compshop.databinding.FragmentRubroBinding
import modelos.Hojalateria
import modelos.HojalateriaProviderPrueba


class HojalateriaFragment : Fragment() {
    private lateinit var binding: FragmentHojalateriaBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHojalateriaBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        initRecyclerView()
    }
    fun initRecyclerView(){
        binding.recyclerviewHojalateria.layoutManager = LinearLayoutManager(activity)
        binding.recyclerviewHojalateria.adapter = AdaptadorHojalateria(HojalateriaProviderPrueba.hojalateriaList, {hojalateria ->  onItemSelected(hojalateria)})

    }
    fun onItemSelected(hojalateria: Hojalateria){
        val intent = Intent(context,MecanicosActivity::class.java)
        intent.putExtra("nombre", hojalateria.nombrebd)
        startActivity(intent)
    }
}