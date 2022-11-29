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
import modelos.Mecanico

class MecanicosAdaptador(private val context: Context) : RecyclerView.Adapter<MecanicosAdaptador.MecanicosViewHolder>() {
    private var datosMecanicoList = mutableListOf<Mecanico>()
    private var nombreServicioAdaptador: String = "DEFAULT"
    private var precioServicio: String = "1000"
    fun setListData(data:MutableList<Mecanico>){
        datosMecanicoList = data
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MecanicosViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_rubros, parent,false)
        return MecanicosViewHolder(view)
    }

    override fun onBindViewHolder(holder: MecanicosViewHolder, position: Int) {
        val mecanico: Mecanico = datosMecanicoList[position]
        holder.bindView(mecanico)
    }

    override fun getItemCount(): Int = datosMecanicoList.size

    inner class MecanicosViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val binding = ItemMecanicosBinding.bind(itemView)

        fun bindView(mecanico:Mecanico){
            binding.nombreMecanico.text = mecanico.nombre
            binding.nombreServicio.text = nombreServicioAdaptador
            binding.precioServicio.text = precioServicio
            Glide.with(binding.imagenMecanico.context).setDefaultRequestOptions(RequestOptions()).load(mecanico.imagen).into(binding.imagenMecanico)
            Toast.makeText((binding.imagenMecanico.context),mecanico.nombre,Toast.LENGTH_LONG).show()
            Log.e("ADAPTADOR",mecanico.nombre)
        }
    }
}