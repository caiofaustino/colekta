package dev.caiofaustino.colekta.newcollection.mvi

import android.os.Parcelable
import dev.caiofaustino.mvi.UiState
import kotlinx.parcelize.Parcelize

@Parcelize
data class NewCollectionUiState(
    val name: String = "",
) : UiState, Parcelable
