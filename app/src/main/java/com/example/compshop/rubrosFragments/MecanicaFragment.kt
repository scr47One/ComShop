package com.example.compshop.mecanicasFragments

import adaptadores.AdaptadorHojalateria
import adaptadores.AdaptadorMecanica
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.compshop.R
import com.example.compshop.databinding.FragmentHojalateriaBinding
import com.example.compshop.databinding.FragmentMecanicaBinding
import com.example.compshop.rubrosFragments.MecanicosActivity
import modelos.Hojalateria
import modelos.HojalateriaProviderPrueba
import modelos.Mecanica
import modelos.MecanicaProviderPrueba


class MecanicaFragment : Fragment() {
    private lateinit var binding: FragmentMecanicaBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMecanicaBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.recyclerviewMecanica.layoutManager = LinearLayoutManager(activity)
        binding.recyclerviewMecanica.adapter = AdaptadorMecanica(MecanicaProviderPrueba.mecanicaList) { mecanica ->
            onItemSelected(
                mecanica
            )
        }
    }
    private fun onItemSelected(mecanica: Mecanica) {
        val intent = Intent(context, MecanicosActivity::class.java)
        intent.putExtra("nombre", mecanica.nombrebd)
        startActivity(intent)
    }

}