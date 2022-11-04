package viewholders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.compshop.R
import modelos.Rubro

class ViewHolderRubro(view: View) : RecyclerView.ViewHolder(view){

    val nombre_rubro = view.findViewById<TextView>(R.id.nombre_rubro)
    val imagen_rubro = view.findViewById<ImageView>(R.id.imagen_rubro)

    fun render(rubroModel: Rubro){
        nombre_rubro.text = rubroModel.nombre_rubro
        Glide.with(imagen_rubro.context).load(rubroModel.imagen_rubro).into(imagen_rubro)
    }
}