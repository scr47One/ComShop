package com.example.compshop.rubrosFragments

import adaptadores.AdaptadorSuspencion
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.compshop.MecanicosActivity
import com.example.compshop.databinding.FragmentSuspencionBinding
import modelos.Suspencion
import modelos.SuspencionProviderPrueba

class SuspencionFragment : Fragment() {
    private lateinit var binding: FragmentSuspencionBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSuspencionBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.recyclerviewSuspencion.layoutManager = LinearLayoutManager(activity)
        binding.recyclerviewSuspencion.adapter = AdaptadorSuspencion(SuspencionProviderPrueba.suspencionList) { suspencion ->
            onItemSelected(
                suspencion
            )
        }
    }
    private fun onItemSelected(suspencion: Suspencion){
        val intent = Intent(context, MecanicosActivity::class.java)
        intent.putExtra("nombre", suspencion.nombrebd)
        startActivity(intent)
    }
}