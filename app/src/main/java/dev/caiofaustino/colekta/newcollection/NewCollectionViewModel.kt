package dev.caiofaustino.colekta.newcollection

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import dev.caiofaustino.colekta.main.MainViewModel
import dev.caiofaustino.colekta.main.mvi.MainProcessor
import dev.caiofaustino.colekta.main.mvi.MainReducer
import dev.caiofaustino.colekta.newcollection.mvi.NewCollectionAction
import dev.caiofaustino.colekta.newcollection.mvi.NewCollectionProcessor
import dev.caiofaustino.colekta.newcollection.mvi.NewCollectionReducer
import dev.caiofaustino.colekta.newcollection.mvi.NewCollectionUiState
import dev.caiofaustino.mvi.MviStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.scan
import kotlinx.coroutines.flow.stateIn

private const val UI_STATE = "NEW_COLLECTION_UI_STATE"

class NewCollectionViewModel(
    private val processor: NewCollectionProcessor,
    reducer: NewCollectionReducer,
    private val savedState: SavedStateHandle,
    viewModelScope: CoroutineScope = CoroutineScope(Dispatchers.Main + SupervisorJob()),
) : ViewModel(viewModelScope), MviStore<NewCollectionUiState> {

    override val uiState: StateFlow<NewCollectionUiState> =
        processor.resultFlow
            .scan(NewCollectionUiState(), reducer::reduce)
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.Lazily,
                initialValue = savedState[UI_STATE] ?: NewCollectionUiState(),
            )
    fun onUserAction(userAction: NewCollectionAction) {
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
