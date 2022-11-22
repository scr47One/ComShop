package com.example.compshop.rubrosFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.compshop.R
import com.example.compshop.databinding.FragmentRubroBinding
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems


class RubroFragment : Fragment(R.layout.fragment_rubro) {

    private lateinit var binding : FragmentRubroBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRubroBinding.bind(view)

        setupTabLayout()
    }

    private fun setupTabLayout(){
        val adapter = FragmentPagerItemAdapter(
            childFragmentManager,
            FragmentPagerItems.with(activity)
                .add("Servicios", ServiciosFragment::class.java)
                .add("Afinacion", AfinacionFragment::class.java)
                .add("Detalles", DetallesFragment::class.java)
                .add("Pintura", PinturaFragment::class.java)
                .create()
        )

        binding.viewpager.adapter = adapter
        binding.viewpagertab.setViewPager(binding.viewpager)


    }
}