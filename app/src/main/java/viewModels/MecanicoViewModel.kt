package viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import modelos.Mecanico

class MecanicoViewModel: ViewModel() {
    private val repoServicios = domain.data.network.RepoMecanico()
    fun fetchUserData():LiveData<MutableList<Mecanico>>{
        val mutableDataMecanico = MutableLiveData<MutableList<Mecanico>>()
        repoServicios.getUserData().observeForever{ mecanicoList->
            mutableDataMecanico.value = mecanicoList
        }
        return mutableDataMecanico
    }
}