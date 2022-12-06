package viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import modelos.Servicio

class ServicioViewModel: ViewModel() {
   private val repoServicios = domain.data.network.RepoServicios()

    fun fetchUserData(nombreObserver: String?):LiveData<MutableList<Servicio>>{

        val mutableDataServicio = MutableLiveData<MutableList<Servicio>>()

        repoServicios.getUserData(nombreObserver).observeForever { servicioList ->
            mutableDataServicio.value = servicioList
        }
        return mutableDataServicio
    }
}