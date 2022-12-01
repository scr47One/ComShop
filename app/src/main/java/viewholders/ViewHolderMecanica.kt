package viewholders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.compshop.R
import com.example.compshop.databinding.ItemRubrosBinding
import modelos.Hojalateria
import modelos.Mecanica

class ViewHolderMecanica(view: View) : RecyclerView.ViewHolder(view){

    val binding = ItemRubrosBinding.bind(view)

    fun render(mecanicaModel: Mecanica, onClickListener:(Mecanica)->Unit){
        binding.nombre.text = mecanicaModel.nombre
        Glide.with(binding.imagen.context).load(mecanicaModel.imagen).into(binding.imagen)
        itemView.setOnClickListener{
            onClickListener(mecanicaModel)
        }
    }
}