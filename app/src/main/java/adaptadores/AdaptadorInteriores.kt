package adaptadores

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.compshop.R
import modelos.Interiores
import viewholders.ViewHolderInteriores

class AdaptadorInteriores(private val interioresList:List<Interiores>) : RecyclerView.Adapter<ViewHolderInteriores>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderInteriores {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolderInteriores(layoutInflater.inflate(R.layout.layout_servicios, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolderInteriores, position: Int) {
        val item = interioresList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = interioresList.size


}