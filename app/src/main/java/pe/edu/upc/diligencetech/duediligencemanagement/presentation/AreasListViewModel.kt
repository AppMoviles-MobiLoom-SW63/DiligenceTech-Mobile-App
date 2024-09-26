package pe.edu.upc.diligencetech.duediligencemanagement.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pe.edu.upc.diligencetech.common.Resource
import pe.edu.upc.diligencetech.duediligencemanagement.data.remote.resources.AreaResource
import pe.edu.upc.diligencetech.duediligencemanagement.data.repositories.AreasRepository
import pe.edu.upc.diligencetech.duediligencemanagement.domain.Area
import javax.inject.Inject

@HiltViewModel
class AreasListViewModel @Inject constructor(
    private val repository: AreasRepository
): ViewModel() {
    private var _areas = SnapshotStateList<Area>()
    val areas: SnapshotStateList<Area> get() = _areas
    private val _newArea = mutableStateOf("")
    val newArea: State<String> get() = _newArea

    fun getAreas(projectId: Long): Boolean {
        viewModelScope.launch {
            val resource = repository.getAreasByProjectId(projectId)
            if (resource is Resource.Success) {
                _areas.clear()
                resource.data.let {
                    _areas.addAll(it!!.toMutableList())
                }
                return@launch
            }
            else {
                return@launch
            }
        }
        return true
    }

    fun onNewAreaChange(newArea: String) {
        _newArea.value = newArea
    }

    fun addArea(projectId: Long): Boolean {
        viewModelScope.launch {
            val areaResource = AreaResource(newArea.value, projectId)
            val resource = repository.createArea(areaResource)
            if (resource is Resource.Success) {
                _areas.clear()
                resource.data.let {
                    _areas.addAll(it!!.toMutableList())
                }
                _newArea.value = ""
                return@launch
            }
            else {
                return@launch
            }
        }
        return true
    }
}