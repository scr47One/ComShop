package viewholders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.compshop.R
import modelos.Suspencion

class ViewHolderSuspencion(view: View) : RecyclerView.ViewHolder(view){

    val nombre = view.findViewById<TextView>(R.id.nombre)
    val imagen = view.findViewById<ImageView>(R.id.imagen)

    fun render(suspencionModel: Suspencion){
        nombre.text = suspencionModel.nombre
        Glide.with(imagen.context).load(suspencionModel.imagen).into(imagen)

    }
}