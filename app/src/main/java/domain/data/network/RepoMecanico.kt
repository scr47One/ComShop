package domain.data.network


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore
import modelos.Mecanico


class RepoMecanico {
    fun getUserData():LiveData<MutableList<Mecanico>>{
        val mutableDataMecanico = MutableLiveData<MutableList<Mecanico>>()
        FirebaseFirestore.getInstance().collection("Mecanico").get().addOnSuccessListener { result->
            val listData= mutableListOf<Mecanico>()
            for(document in result ){

                val nombre = document.getString("nombre")
                val imagen= document.getString("imagen")
                val telefono= document.getString("telefono")
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
                val mecanico = Mecanico(nombre!!,imagen!!,telefono!!,aceite,
                    afinacion,alfombra,alineacion,
                    amortiguadores,asientos,balanceo,
                    bandas,empastado,encerado,pulido)

                listData.add(mecanico)

            }
            mutableDataMecanico.value=listData

        }
        return mutableDataMecanico
    }
}