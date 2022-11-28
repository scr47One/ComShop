package adaptadores

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.compshop.R
import modelos.Rubro
import viewholders.BaseViewHolder

class RubroAdaptador(private val rubroList:List<Rubro>) : RecyclerView.Adapter<BaseViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return BaseViewHolder(layoutInflater.inflate(R.layout.layout_servicios, parent, false))
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val item = rubroList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = rubroList.size

}