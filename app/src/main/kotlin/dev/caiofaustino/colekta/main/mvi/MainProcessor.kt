package dev.caiofaustino.colekta.main.mvi

import dev.caiofaustino.colekta.main.mvi.MainAction.CreateCollection
import dev.caiofaustino.colekta.main.mvi.MainSideEffect.NavigateTo
import dev.caiofaustino.colekta.navigation.DestinationScreen.NewCollectionScreen
import dev.caiofaustino.mvi.MviProcessor
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import logcat.logcat

class MainProcessor : MviProcessor<MainAction, MainResult, MainSideEffect> {
    private val _resultFlow = MutableSharedFlow<MainResult>()
    override val resultFlow: SharedFlow<MainResult> = _resultFlow.asSharedFlow()

    private val _sideEffectFlow = MutableSharedFlow<MainSideEffect>()
    override val sideEffectFlow: SharedFlow<MainSideEffect> = _sideEffectFlow.asSharedFlow()

    override suspend fun process(action: MainAction) {
        when (action) {
            CreateCollection -> {
                logcat { "Create Collection" }
                _sideEffectFlow.emit(NavigateTo(NewCollectionScreen))
            }
        }
    }
}
