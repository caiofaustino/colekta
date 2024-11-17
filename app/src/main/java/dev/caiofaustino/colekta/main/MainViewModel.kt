package dev.caiofaustino.colekta.main

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import dev.caiofaustino.mvi.MviStore
import dev.caiofaustino.colekta.main.mvi.MainAction
import dev.caiofaustino.colekta.main.mvi.MainProcessor
import dev.caiofaustino.colekta.main.mvi.MainReducer
import dev.caiofaustino.colekta.main.mvi.MainUiState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.scan
import kotlinx.coroutines.flow.stateIn

private const val UI_STATE = "MAIN_UI_STATE"

class MainViewModel(
    private val processor: MainProcessor,
    reducer: MainReducer,
    private val savedState: SavedStateHandle,
    viewModelScope: CoroutineScope = CoroutineScope(Dispatchers.Main + SupervisorJob()),
) : ViewModel(viewModelScope), MviStore<MainUiState> {
    // TODO: Check Multiplatform ViewModel

    override val uiState: StateFlow<MainUiState> =
        processor.resultFlow
            .scan(MainUiState(), reducer::reduce)
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.Lazily,
                initialValue = savedState[UI_STATE] ?: MainUiState(),
            )

    fun onUserAction(userAction: MainAction) {
        processor.process(userAction)
    }

    override fun onCleared() {
        super.onCleared()
        savedState[UI_STATE] = uiState.value
    }

    companion object {
        val factory =
            viewModelFactory {
                initializer {
                    MainViewModel(
                        processor = MainProcessor(),
                        reducer = MainReducer(),
                        savedState = createSavedStateHandle(),
                    )
                }
            }
    }
}
