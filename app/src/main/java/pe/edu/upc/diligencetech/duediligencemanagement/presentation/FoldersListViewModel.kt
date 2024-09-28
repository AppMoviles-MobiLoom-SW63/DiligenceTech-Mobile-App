package pe.edu.upc.diligencetech.duediligencemanagement.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pe.edu.upc.diligencetech.common.Resource
import pe.edu.upc.diligencetech.duediligencemanagement.data.remote.resources.FolderResource
import pe.edu.upc.diligencetech.duediligencemanagement.data.repositories.FoldersRepository
import pe.edu.upc.diligencetech.duediligencemanagement.domain.Folder
import javax.inject.Inject

@HiltViewModel
class FoldersListViewModel @Inject constructor(
    private val repository: FoldersRepository
) : ViewModel() {

    private var _folders = SnapshotStateList<Folder>()
    val folders: SnapshotStateList<Folder> get() = _folders

    private val _newFolder = mutableStateOf("")
    val newFolder: State<String> get() = _newFolder

    private val _selectedProjectName = mutableStateOf("")
    val selectedProjectName: State<String> get() = _selectedProjectName

    // Modificación: recibir projectName directamente como parámetro
    fun getFolders(areaId: Long, projectName: String): Boolean {
        viewModelScope.launch {
            // Usamos el projectName directamente
            _selectedProjectName.value = projectName

            val resource = repository.getFoldersByAreaId(areaId)
            if (resource is Resource.Success) {
                _folders.clear()
                resource.data?.let {
                    _folders.addAll(it.toMutableList())
                }
                return@launch
            } else {
                return@launch
            }
        }
        return true
    }

    fun onNewFolderChange(newFolder: String) {
        _newFolder.value = newFolder
    }

    fun addFolder(areaId: Long): Boolean {
        viewModelScope.launch {
            val folderResource = FolderResource(areaId, newFolder.value)
            val resource = repository.createFolder(folderResource)
            if (resource is Resource.Success) {
                _folders.clear()
                resource.data?.let {
                    _folders.addAll(it.toMutableList())
                }
                _newFolder.value = ""
                return@launch
            } else {
                return@launch
            }
        }
        return true
    }
}
