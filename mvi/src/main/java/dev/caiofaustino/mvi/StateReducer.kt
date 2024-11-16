package dev.caiofaustino.mvi

/**
 * Transforms the [UiState] according to the received [MviResult]
 */
interface StateReducer<in ResultT : MviResult, UiStateT : UiState> {
    fun reduce(previousState : UiStateT, result: ResultT) : UiStateT
}