package viewholders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.compshop.R
import modelos.Interiores

class ViewHolderInteriores(view: View) : RecyclerView.ViewHolder(view){

    val nombre = view.findViewById<TextView>(R.id.nombre)
    val imagen = view.findViewById<ImageView>(R.id.imagen)

    fun render(interioresModel: Interiores){
        nombre.text = interioresModel.nombre
        Glide.with(imagen.context).load(interioresModel.imagen).into(imagen)

    }
}