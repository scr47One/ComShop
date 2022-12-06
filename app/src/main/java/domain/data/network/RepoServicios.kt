package domain.data.network


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore
import modelos.Servicio

class RepoServicios {
    fun getUserData(nombreObserver: String?):LiveData<MutableList<Servicio>>{

        val mutableDataServicio = MutableLiveData<MutableList<Servicio>>()
        FirebaseFirestore.getInstance().collection("Mecanico").get().addOnSuccessListener { result->
            val listServicio = mutableListOf<Servicio>()
            for(document in result ){

                val nombre = document.getString("nombre")
                val imagen= document.getString("imagen")

                val precioServicio = document.getDouble(nombreObserver.toString())!!.toInt()

                val servicio = Servicio(nombre!!,nombreObserver.toString(),precioServicio,imagen!!)

                listServicio.add(servicio)
            }

            mutableDataServicio.value=listServicio
        }
        return mutableDataServicio
    }
}