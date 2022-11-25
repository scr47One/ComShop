package com.example.compshop.mecanicasFragments

import adaptadores.AdaptadorMecanica
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.compshop.R
import modelos.MecanicaProviderPrueba


class MecanicaFragment : Fragment() {
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<viewholders.ViewHolderMecanica>? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_mecanica, container, false)
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        var recyclerview_mecanica = itemView.findViewById<RecyclerView>(R.id.recyclerview_mecanica)
        recyclerview_mecanica.apply{
            layoutManager = LinearLayoutManager(activity)
            adapter = AdaptadorMecanica(MecanicaProviderPrueba.mecanicaList)
        }
    }

}