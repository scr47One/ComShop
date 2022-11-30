package viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.compshop.databinding.ItemRubrosBinding
import modelos.Hojalateria

class ViewHolderHojalateria(view: View) : RecyclerView.ViewHolder(view){
    val binding = ItemRubrosBinding.bind(view)


    fun render(hojalateriaModel: Hojalateria, onClickListener:(Hojalateria)->Unit){
        binding.nombre.text = hojalateriaModel.nombre
        Glide.with(binding.imagen.context).load(hojalateriaModel.imagen).into(binding.imagen)
        itemView.setOnClickListener{
            onClickListener(hojalateriaModel)
        }
    }
}