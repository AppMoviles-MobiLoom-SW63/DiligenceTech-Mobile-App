package pe.edu.upc.diligencetech.duediligencemanagement.presentation

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pe.edu.upc.diligencetech.common.Resource
import pe.edu.upc.diligencetech.duediligencemanagement.data.remote.resources.DueDiligenceProjectResource
import pe.edu.upc.diligencetech.duediligencemanagement.data.remote.resources.FolderResource
import pe.edu.upc.diligencetech.duediligencemanagement.data.repositories.DueDiligenceProjectsRepository
import pe.edu.upc.diligencetech.duediligencemanagement.domain.DueDiligenceProject
import javax.inject.Inject

@HiltViewModel
class ProjectsListViewModel @Inject constructor(
    private val repository: DueDiligenceProjectsRepository
): ViewModel() {
    private var _projects = SnapshotStateList<DueDiligenceProject>()
    val projects: SnapshotStateList<DueDiligenceProject> get() = _projects
    private val _newProject = mutableStateOf("")
    val newProject: State<String> get() = _newProject
    private val _rawBuyAgents = mutableStateOf("")
    val rawBuyAgents: State<String> get() = _rawBuyAgents
    private val _rawSellAgents = mutableStateOf("")
    val rawSellAgents: State<String> get() = _rawSellAgents

    fun getProjects(): Boolean {
        viewModelScope.launch {
            val resource = repository.getDueDiligenceProjectsByUsername()
            if (resource is Resource.Success) {
                _projects.clear()
                resource.data.let {
                    _projects.addAll(it!!.toMutableList())
                }
                return@launch
            }
            else {
                return@launch
            }
        }
        return true
    }

    fun onNewProjectChange(newProject: String) {
        _newProject.value = newProject
    }

    fun onRawBuyAgentsChange(rawBuyAgents: String) {
        _rawBuyAgents.value = rawBuyAgents
    }

    fun onRawSellAgentsChange(rawSellAgents: String) {
        _rawSellAgents.value = rawSellAgents
    }

    fun addProject(): Boolean {
        // transform into correct format
        val buyAgents = rawBuyAgents.value.split(",").map { it.trim() }
        val sellAgents = rawSellAgents.value.split(",").map { it.trim() }
        Log.d("Add Project", "Adding project")
        var roles: List<Boolean> = buyAgents.map {
            return@map true
        }
        Log.d("Add Project", "Adding project")
        val agents = buyAgents + sellAgents
        roles = roles + sellAgents.map {
            return@map false
        }
        Log.d("Add Project", "Adding project")
        val projectResource = DueDiligenceProjectResource(roles, agents, newProject.value)
        viewModelScope.launch {
            val resource = repository.createDueDiligenceProject(projectResource)
            if (resource is Resource.Success) {
                _projects.clear()
                resource.data.let {
                    _projects.addAll(it!!.toMutableList())
                }
                _newProject.value = ""
                _rawBuyAgents.value = ""
                _rawSellAgents.value = ""
                return@launch
            }
            else {
                return@launch
            }
        }
        return true
    }
}