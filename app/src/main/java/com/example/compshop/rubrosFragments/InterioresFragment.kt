package com.example.compshop.interioressFragments


import adaptadores.AdaptadorInteriores
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.compshop.databinding.FragmentInterioresBinding
import com.example.compshop.MecanicosActivity
import modelos.Interiores
import modelos.InterioresProviderPrueba


class InterioresFragment : Fragment() {

    private lateinit var binding: FragmentInterioresBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInterioresBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.recyclerviewInteriores.layoutManager = LinearLayoutManager(activity)
        binding.recyclerviewInteriores.adapter = AdaptadorInteriores(InterioresProviderPrueba.interioresList) { interiores ->
            onItemSelected(
                interiores
            )
        }

    }

    private fun onItemSelected(interiores: Interiores) {
        val intent = Intent(context, MecanicosActivity::class.java)
        intent.putExtra("nombre", interiores.nombrebd)
        startActivity(intent)
    }

}