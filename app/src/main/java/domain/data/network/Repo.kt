package domain.data.network

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore
import modelos.Mecanico
import modelos.Servicio

class Repo {

    fun getUserData(nombreObserver: String):Pair<LiveData<MutableList<Mecanico>>,LiveData<MutableList<Servicio>>>{
        val mutableDataMecanico = MutableLiveData<MutableList<Mecanico>>()
        val mutableDataServicio = MutableLiveData<MutableList<Servicio>>()
        FirebaseFirestore.getInstance().collection("Mecanico").get().addOnSuccessListener { result->
            val listServicio = mutableListOf<Servicio>()
            val listData= mutableListOf<Mecanico>()
            for(document in result ){
                val nombre = document.getString("nombre")
                val imagen= document.getString("imagen")
                val telefono= document.getDouble("telefono")!!.toInt()
                val precioServicio = document.getDouble(nombreObserver)!!.toInt()
                val aceite= document.getDouble("aceite")!!.toInt()
                val afinacion= document.getDouble("afinacion")!!.toInt()
                val alfombra= document.getDouble("alfombra")!!.toInt()
                val alineacion= document.getDouble("alineacion")!!.toInt()
                val amortiguadores= document.getDouble("amortiguadores")!!.toInt()
                val asientos= document.getDouble("asientos")!!.toInt()
                val balanceo= document.getDouble("balanceo")!!.toInt()
                val bandas= document.getDouble("bandas")!!.toInt()
                val empastado= document.getDouble("empastado")!!.toInt()
                val encerado = document.getDouble("encerado")!!.toInt()
                val pulido= document.getDouble("pulido")!!.toInt()
                Log.e("nombre",nombre!!)
                val mecanico = Mecanico(nombre!!,imagen!!,telefono,aceite,
                        afinacion,alfombra,alineacion,
                        amortiguadores,asientos,balanceo,
                        bandas,empastado,encerado,pulido)
                val servicio = Servicio(nombre,nombreObserver,precioServicio,imagen)
                listData.add(mecanico)
                listServicio.add(servicio)
            }
            mutableDataMecanico.value=listData
            mutableDataServicio.value=listServicio
        }
        return Pair(mutableDataMecanico,mutableDataServicio)
    }


}