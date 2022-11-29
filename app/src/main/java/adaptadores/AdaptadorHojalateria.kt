package adaptadores

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.compshop.R
import modelos.Hojalateria
import viewholders.ViewHolderHojalateria

class AdaptadorHojalateria(private val hojalateriaList:List<Hojalateria>, private val onClickListener:(Hojalateria)->Unit) : RecyclerView.Adapter<ViewHolderHojalateria>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderHojalateria {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolderHojalateria(layoutInflater.inflate(R.layout.item_rubros, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolderHojalateria, position: Int) {
        val item = hojalateriaList[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int = hojalateriaList.size


}