package adaptadores

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.compshop.R
import modelos.Suspencion
import viewholders.ViewHolderSuspencion

class AdaptadorSuspencion(private val suspencionList:List<Suspencion>) : RecyclerView.Adapter<ViewHolderSuspencion>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderSuspencion {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolderSuspencion(layoutInflater.inflate(R.layout.item_rubros, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolderSuspencion, position: Int) {
        val item = suspencionList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = suspencionList.size


}