package com.example.compshop.rubrosFragments

import adaptadores.AdaptadorRubro
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.compshop.R
import modelos.RubroProviderPrueba


class ServiciosFragment : Fragment() {
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<viewholders.ViewHolderRubro>? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_afinacion, container, false)
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        var recyclerview_rubro = itemView.findViewById<RecyclerView>(R.id.recyclerview_rubro)
        recyclerview_rubro.apply{
            layoutManager = LinearLayoutManager(activity)
            adapter = AdaptadorRubro(RubroProviderPrueba.rubroList)
        }
    }

}