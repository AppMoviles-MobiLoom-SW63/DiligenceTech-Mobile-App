package pe.edu.upc.diligencetech.duediligencemanagement.presentation
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import pe.edu.upc.diligencetech.common.Resource
import pe.edu.upc.diligencetech.duediligencemanagement.data.repositories.DueDiligenceProjectsRepository
import pe.edu.upc.diligencetech.duediligencemanagement.domain.DueDiligenceProject
import javax.inject.Inject


@HiltViewModel
class ProjectsListViewModel @Inject constructor(
    private val repository: DueDiligenceProjectsRepository
) : ViewModel() {

    private val _projects = MutableStateFlow<List<DueDiligenceProject>>(emptyList())
    val projects = _projects.asStateFlow()

    private val _isLoading = MutableStateFlow(true)
    val isLoading = _isLoading.asStateFlow()

    fun loadProjects() {
        viewModelScope.launch {
            _isLoading.value = true
            when (val result = repository.getDueDiligenceProjectByUserAndUsername()) {
                is Resource.Success -> {
                    _projects.value = result.data ?: emptyList()
                }
                is Resource.Error -> {
                }
            }
            _isLoading.value = false
        }
    }
}