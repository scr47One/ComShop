package adaptadores

import adaptadores.glide.GlideApp
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.compshop.R
import com.example.compshop.databinding.ItemMecanicosBinding
import modelos.Servicio

class MecanicosAdaptador(private val context: Context) : RecyclerView.Adapter<MecanicosAdaptador.MecanicosViewHolder>() {
    private var datosServicioList = mutableListOf<Servicio>()
    fun setListData(data:MutableList<Servicio>){
        datosServicioList = data
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MecanicosViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_mecanicos, parent,false)
        return MecanicosViewHolder(view)
    }

    override fun onBindViewHolder(holder: MecanicosViewHolder, position: Int) {
        val servicio: Servicio = datosServicioList[position]
        if(servicio.precioServicio!=0){
            holder.bindView(servicio)
        }
    }

    override fun getItemCount(): Int = datosServicioList.size

    inner class MecanicosViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        private val binding = ItemMecanicosBinding.bind(itemView)
        fun bindView(servicio:Servicio){
            binding.nombreMecanico.text = servicio.nombreMecanico
            binding.nombreServicio.text = servicio.nombreServicio
            binding.precioServicio.text = servicio.precioServicio.toString()
            GlideApp.with(binding.imagenMecanico.context).load(servicio.imagenMecanico).into(binding.imagenMecanico)
        }
    }
}