package com.example.compshop.suspencionsFragments

import adaptadores.AdaptadorSuspencion
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.compshop.R
import modelos.SuspencionProviderPrueba

class SuspencionFragment : Fragment() {
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<viewholders.ViewHolderSuspencion>? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_suspencion, container, false)
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        var recyclerview_suspencion = itemView.findViewById<RecyclerView>(R.id.recyclerview_suspencion)
        recyclerview_suspencion.apply{
            layoutManager = LinearLayoutManager(activity)
            adapter = AdaptadorSuspencion(SuspencionProviderPrueba.suspencionList)
        }
    }
}