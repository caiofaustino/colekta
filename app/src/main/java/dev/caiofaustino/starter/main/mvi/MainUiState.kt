package dev.caiofaustino.starter.main.mvi

import android.os.Parcelable
import dev.caiofaustino.mvi.UiState
import kotlinx.parcelize.Parcelize

@Parcelize
data class MainUiState(
    val text: String = "Hello Android!",
) : UiState, Parcelable
