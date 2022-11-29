package viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import modelos.Mecanico

class MecanicosViewModel: ViewModel() {
   private val repo = domain.data.network.Repo()

    fun fetchUserData(nombreObserver: String):LiveData<MutableList<Mecanico>>{
        val mutableData = MutableLiveData<MutableList<Mecanico>>()
        repo.getUserData(nombreObserver).observeForever{ mecanicoList->
            mutableData.value =mecanicoList
        }
        return mutableData
    }
}