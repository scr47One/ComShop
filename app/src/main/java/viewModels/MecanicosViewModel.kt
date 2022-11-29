package viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import modelos.Mecanico
import modelos.Servicio

class MecanicosViewModel: ViewModel() {
   private val repo = domain.data.network.Repo()

    fun fetchUserData(nombreObserver: String):Pair<LiveData<MutableList<Mecanico>>,LiveData<MutableList<Servicio>>>{
        val mutableDataMecanico = MutableLiveData<MutableList<Mecanico>>()
        val mutableDataServicio = MutableLiveData<MutableList<Servicio>>()
        repo.getUserData(nombreObserver).first.observeForever{ mecanicoList->
            mutableDataMecanico.value =mecanicoList
        }
        repo.getUserData(nombreObserver).second.observeForever { servicioList ->
            mutableDataServicio.value = servicioList
        }
        return Pair(mutableDataMecanico,mutableDataServicio)
    }
}