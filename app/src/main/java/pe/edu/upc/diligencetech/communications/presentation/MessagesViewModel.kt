package pe.edu.upc.diligencetech.communications.presentation

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pe.edu.upc.diligencetech.common.Resource
import pe.edu.upc.diligencetech.communications.data.repositories.MessagesRepository
import pe.edu.upc.diligencetech.communications.domain.Messages
import javax.inject.Inject

@HiltViewModel
class MessagesViewModel @Inject constructor(
    private val repository: MessagesRepository
): ViewModel(){
    private var _messages = SnapshotStateList<Messages>()
    val messages: SnapshotStateList<Messages> get() = _messages

    fun getMessagesByProjectId(projectId: Long) {
        viewModelScope.launch {
            val resource = repository.getMessagesByProjectId(projectId)
            if (resource is Resource.Success) {
                _messages.clear()
                resource.data?.let {
                    _messages.addAll(it.toMutableList())
                }
            }
        }
    }

    fun getMessagesByUsername(username: String) {
        viewModelScope.launch {
            val resource = repository.getMessagesByUsername(username)
            if (resource is Resource.Success) {
                _messages.clear()
                resource.data?.let {
                    _messages.addAll(it.toMutableList())
                }
            }
        }
    }
}