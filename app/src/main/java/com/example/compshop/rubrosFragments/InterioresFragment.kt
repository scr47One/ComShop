package com.example.compshop.interioressFragments

import adaptadores.AdaptadorInteriores
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.compshop.*
import modelos.InterioresProviderPrueba


class InterioresFragment : Fragment() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<viewholders.ViewHolderInteriores>? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       return inflater.inflate(R.layout.fragment_interiores, container, false)
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        var recyclerview_interiores = itemView.findViewById<RecyclerView>(R.id.recyclerview_interiores)
        recyclerview_interiores.apply{
            layoutManager = LinearLayoutManager(activity)
            adapter = AdaptadorInteriores(InterioresProviderPrueba.interioresList)
        }
    }

}