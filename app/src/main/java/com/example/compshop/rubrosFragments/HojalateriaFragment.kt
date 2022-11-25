package com.example.compshop.rubrosFragments

import adaptadores.AdaptadorHojalateria
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.compshop.R
import modelos.HojalateriaProviderPrueba


class HojalateriaFragment : Fragment() {
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<viewholders.ViewHolderHojalateria>? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hojalateria, container, false)
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        var recyclerview_hojalateria = itemView.findViewById<RecyclerView>(R.id.recyclerview_hojalateria)
        recyclerview_hojalateria.apply{
            layoutManager = LinearLayoutManager(activity)
            adapter = AdaptadorHojalateria(HojalateriaProviderPrueba.hojalateriaList)
        }
    }
}