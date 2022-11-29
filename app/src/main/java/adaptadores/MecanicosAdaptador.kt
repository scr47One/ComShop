package adaptadores

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.compshop.R
import com.example.compshop.databinding.ItemMecanicosBinding
import modelos.Servicio


class MecanicosAdaptador(private val context: Context) : RecyclerView.Adapter<MecanicosAdaptador.MecanicosViewHolder>() {
    private var datosMecanicoList = mutableListOf<Servicio>()
    fun setListData(data:MutableList<Servicio>){
        datosMecanicoList = data
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MecanicosViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_rubros, parent,false)
        return MecanicosViewHolder(view)
    }

    override fun onBindViewHolder(holder: MecanicosViewHolder, position: Int) {
        val servicio: Servicio = datosMecanicoList[position]
        holder.bindView(servicio)
    }

    override fun getItemCount(): Int = datosMecanicoList.size

    inner class MecanicosViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val binding = ItemMecanicosBinding.bind(itemView)

        fun bindView(servicio:Servicio){
            binding.nombreMecanico.text = servicio.nombreMecanico
            binding.nombreServicio.text = servicio.nombreServicio
            binding.precioServicio.text = servicio.precioServicio.toString()
            Glide.with(binding.imagenMecanico.context).setDefaultRequestOptions(RequestOptions()).load(servicio.imagenMecanico).into(binding.imagenMecanico)
        }
    }
}