package adaptadores

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.compshop.R
import modelos.Hojalateria
import modelos.Mecanica
import viewholders.ViewHolderMecanica

class AdaptadorMecanica(private val mecanicaList:List<Mecanica>, private val onClickListener:(Mecanica)->Unit) : RecyclerView.Adapter<ViewHolderMecanica>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderMecanica {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolderMecanica(layoutInflater.inflate(R.layout.item_rubros, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolderMecanica, position: Int) {
        val item = mecanicaList[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int = mecanicaList.size


}