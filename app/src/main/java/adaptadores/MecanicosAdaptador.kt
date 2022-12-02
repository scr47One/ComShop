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

class MecanicosAdaptador(private val context: Context, private val onClickListener:(Servicio)->Unit) : RecyclerView.Adapter<MecanicosAdaptador.MecanicosViewHolder>() {
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
            holder.bindView(servicio,onClickListener)
    }

    override fun getItemCount(): Int = datosServicioList.size

    inner class MecanicosViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
         val binding = ItemMecanicosBinding.bind(itemView)

        fun bindView(servicio:Servicio, onClickListener:(Servicio)->Unit){
            binding.nombreMecanico.text = servicio.nombreMecanico
            binding.nombreServicio.text = servicio.nombreServicio
            binding.precioServicio.text = "$${servicio.precioServicio}"
            GlideApp.with(binding.imagenMecanico.context).load(servicio.imagenMecanico).into(binding.imagenMecanico)
            itemView.setOnClickListener{
                onClickListener(servicio)
            }
        }
    }

}