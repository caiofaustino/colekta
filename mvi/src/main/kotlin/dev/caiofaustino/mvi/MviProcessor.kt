package dev.caiofaustino.mvi

import kotlinx.coroutines.flow.SharedFlow

/**
 * Responsible for receiving an [MviAction] and processing them into a [MviResult]
 */
interface MviProcessor<ActionT : MviAction, ResultT : MviResult, SideEffectT : MviSideEffect> {
    val resultFlow: SharedFlow<ResultT>
    val sideEffectFlow: SharedFlow<SideEffectT>
    suspend fun process(action: ActionT)
}