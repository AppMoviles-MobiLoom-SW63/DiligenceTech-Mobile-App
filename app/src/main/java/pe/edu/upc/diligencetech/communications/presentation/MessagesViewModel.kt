package pe.edu.upc.diligencetech.communications.presentation

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import pe.edu.upc.diligencetech.common.Resource
import pe.edu.upc.diligencetech.communications.data.repositories.MessagesRepository
import pe.edu.upc.diligencetech.communications.domain.Messages
import javax.inject.Inject

@HiltViewModel
class MessagesViewModel @Inject constructor(
    private val repository: MessagesRepository
): ViewModel() {
    private val _messages = MutableStateFlow<List<Messages>>(emptyList())
    val messages: StateFlow<List<Messages>> get() = _messages

    fun getMessagesByProjectId(projectId: Long) {
        viewModelScope.launch {
            val resource = repository.getMessagesByProjectId(projectId)
            if (resource is Resource.Success) {
                _messages.value = resource.data ?: emptyList()
            }
        }
    }

    fun getMessageById(messageId: Long) = flow {
        val resource = repository.getMessageById(messageId)
        if (resource is Resource.Success) {
            emit(resource.data)
        } else {
            emit(null)
        }
    }
}