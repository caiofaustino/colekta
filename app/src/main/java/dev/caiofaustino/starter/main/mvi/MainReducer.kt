package dev.caiofaustino.starter.main.mvi

import dev.caiofaustino.mvi.StateReducer

class MainReducer : StateReducer<MainResult, MainUiState> {
    override fun reduce(
        previousState: MainUiState,
        result: MainResult,
    ): MainUiState {
        TODO("Not yet implemented")
    }
}
