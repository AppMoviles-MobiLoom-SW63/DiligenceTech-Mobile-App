package pe.edu.upc.diligencetech.communications.presentation

import android.os.Message
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
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
    val messages: StateFlow<List<Messages>> = _messages.asStateFlow()

    fun fetchMessagesForProject(projectId: Long) {
        viewModelScope.launch {
            when (val result = repository.getMessagesByProjectId(projectId)) {
                is Resource.Success -> _messages.value = result.data ?: emptyList()
                is Resource.Error -> _messages.value = emptyList()
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