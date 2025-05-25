package dev.caiofaustino.colekta.newcollection.mvi

import dev.caiofaustino.colekta.newcollection.mvi.NewCollectionAction.CreateNewCollection
import dev.caiofaustino.mvi.MviProcessor
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import logcat.logcat

class NewCollectionProcessor : MviProcessor<NewCollectionAction, NewCollectionResult, NewCollectionSideEffect> {
    private val _resultFlow = MutableSharedFlow<NewCollectionResult>()
    override val resultFlow: SharedFlow<NewCollectionResult> = _resultFlow.asSharedFlow()

    override val sideEffectFlow: SharedFlow<NewCollectionSideEffect> =
        MutableSharedFlow<NewCollectionSideEffect>().asSharedFlow()

    override suspend fun process(action: NewCollectionAction) {
        when (action) {
            is CreateNewCollection -> {
                if (action.name.isEmpty()) {
                    logcat { "Collection name is Empty." }
                } else {
                    logcat { "Create New Collection - ${action.name}" }
                }
            }
        }
    }
}
