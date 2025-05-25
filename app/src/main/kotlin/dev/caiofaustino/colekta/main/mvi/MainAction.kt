package dev.caiofaustino.colekta.main.mvi

import dev.caiofaustino.mvi.MviAction

sealed interface MainAction : MviAction {
    data object CreateCollection : MainAction
}
