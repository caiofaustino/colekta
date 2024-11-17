package dev.caiofaustino.colekta.newcollection.mvi

import android.util.Log
import dev.caiofaustino.colekta.newcollection.mvi.NewCollectionAction.CreateNewCollection
import dev.caiofaustino.mvi.MviProcessor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class NewCollectionProcessor : MviProcessor<NewCollectionAction, NewCollectionResult> {
    private val _resultFlow = MutableSharedFlow<NewCollectionResult>()
    override val resultFlow: Flow<NewCollectionResult> = _resultFlow.asSharedFlow()

    override fun process(action: NewCollectionAction) {
        when (action) {
            is CreateNewCollection -> {
                Log.e("TEST", "Create New Collection - ${action.name}")
            }
        }
    }
}
