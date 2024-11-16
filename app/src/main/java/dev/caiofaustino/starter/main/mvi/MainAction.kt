package dev.caiofaustino.starter.main.mvi

import dev.caiofaustino.mvi.MviAction

sealed interface MainAction : MviAction {
    data object ButtonClicked : MainAction
}
