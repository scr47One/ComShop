package viewholders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.compshop.R
import com.example.compshop.databinding.ItemRubrosBinding
import modelos.Hojalateria
import modelos.Interiores

class ViewHolderInteriores(view: View) : RecyclerView.ViewHolder(view){

    val binding = ItemRubrosBinding.bind(view)


    fun render(interioresModel: Interiores, onClickListener:(Interiores)->Unit){
        binding.nombre.text = interioresModel.nombre
        Glide.with(binding.imagen.context).load(interioresModel.imagen).into(binding.imagen)
        itemView.setOnClickListener{
            onClickListener(interioresModel)
        }
    }
}