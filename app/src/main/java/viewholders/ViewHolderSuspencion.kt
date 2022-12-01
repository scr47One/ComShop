package viewholders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.compshop.R
import com.example.compshop.databinding.ItemRubrosBinding
import modelos.Hojalateria
import modelos.Suspencion

class ViewHolderSuspencion(view: View) : RecyclerView.ViewHolder(view){

    val binding = ItemRubrosBinding.bind(view)

    fun render(suspencionModel: Suspencion,  onClickListener:(Suspencion)->Unit){
        binding.nombre.text = suspencionModel.nombre
        Glide.with(binding.imagen.context).load(suspencionModel.imagen).into(binding.imagen)
        itemView.setOnClickListener{
            onClickListener(suspencionModel)
        }
    }
}