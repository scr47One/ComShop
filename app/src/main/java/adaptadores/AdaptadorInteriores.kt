package adaptadores

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.compshop.R
import modelos.Hojalateria
import modelos.Interiores
import viewholders.ViewHolderInteriores

class AdaptadorInteriores(private val interioresList:List<Interiores>, private val onClickListener:(Interiores)->Unit) : RecyclerView.Adapter<ViewHolderInteriores>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderInteriores {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolderInteriores(layoutInflater.inflate(R.layout.item_rubros, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolderInteriores, position: Int) {
        val item = interioresList[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int = interioresList.size


}