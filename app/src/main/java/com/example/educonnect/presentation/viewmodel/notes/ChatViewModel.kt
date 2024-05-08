package com.example.educonnect.presentation.viewmodel.notes

import androidx.lifecycle.ViewModel
import com.example.educonnect.presentation.view.chat.ChatListScreenModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ChatViewModel: ViewModel() {
    private val _chatUIState = MutableStateFlow(ChatListScreenModel())
    val chatUIState = _chatUIState.asStateFlow()

    fun getInfo(photo: Int, name: String){
        _chatUIState.update {
            it.copy(
                photo = photo,
                name = name
            )
        }
    }
}

