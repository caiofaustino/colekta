package dev.caiofaustino.mvi

import kotlinx.coroutines.flow.Flow

/**
 * Stores the current UiState and receives
 */
interface MviStore<StateT : UiState> {
    val uiState: Flow<StateT>
}