package com.example.compshop.mecanicasFragments

import adaptadores.AdaptadorMecanica
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.compshop.databinding.FragmentMecanicaBinding
import com.example.compshop.MecanicosActivity
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