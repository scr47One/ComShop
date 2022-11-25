package adaptadores

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.compshop.R
import modelos.Mecanica
import viewholders.ViewHolderMecanica

class AdaptadorMecanica(private val mecanicaList:List<Mecanica>) : RecyclerView.Adapter<ViewHolderMecanica>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderMecanica {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolderMecanica(layoutInflater.inflate(R.layout.layout_servicios, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolderMecanica, position: Int) {
        val item = mecanicaList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = mecanicaList.size


}