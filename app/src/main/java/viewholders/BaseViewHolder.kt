package viewholders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.compshop.R
import modelos.Rubro

class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view){

    val nombre = view.findViewById<TextView>(R.id.nombre)
    val imagen = view.findViewById<ImageView>(R.id.imagen)

    fun render(rubroModel: Rubro){
        nombre.text = rubroModel.nombre
        Glide.with(imagen.context).load(rubroModel.imagen).into(imagen)

    }
}