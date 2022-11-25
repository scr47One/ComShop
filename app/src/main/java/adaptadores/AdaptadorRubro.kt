package adaptadores

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.compshop.R
import modelos.Rubro
import viewholders.ViewHolderRubro

class AdaptadorRubro(private val rubroList:List<Rubro>) : RecyclerView.Adapter<ViewHolderRubro>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderRubro {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolderRubro(layoutInflater.inflate(R.layout.layout_servicios, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolderRubro, position: Int) {
        val item = rubroList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = rubroList.size


}