package dev.caiofaustino.mvi

import kotlinx.coroutines.flow.Flow

/**
 * Responsible for receiving an [MviAction] and processing them into a [MviResult]
 */
interface MviProcessor<ActionT : MviAction, ResultT : MviResult> {
    val resultFlow: Flow<MviResult>
    fun process(action: ActionT)
}