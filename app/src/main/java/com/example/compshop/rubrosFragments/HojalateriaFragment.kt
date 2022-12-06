package com.example.compshop.rubrosFragments

import adaptadores.AdaptadorHojalateria
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.compshop.MecanicosActivity
import com.example.compshop.databinding.FragmentHojalateriaBinding
import modelos.Hojalateria
import modelos.HojalateriaProviderPrueba


class HojalateriaFragment : Fragment() {
    private lateinit var binding: FragmentHojalateriaBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHojalateriaBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        initRecyclerView()
    }
    fun initRecyclerView(){
        binding.recyclerviewHojalateria.layoutManager = LinearLayoutManager(activity)
        binding.recyclerviewHojalateria.adapter = AdaptadorHojalateria(HojalateriaProviderPrueba.hojalateriaList) { hojalateria ->
            onItemSelected(
                hojalateria
            )
        }
    }
    private fun onItemSelected(hojalateria: Hojalateria){
        val intent = Intent(context, MecanicosActivity::class.java)
        intent.putExtra("nombre", hojalateria.nombrebd)
        startActivity(intent)
    }
}