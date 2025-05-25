package dev.caiofaustino.colekta.newcollection.mvi

import dev.caiofaustino.mvi.MviAction

sealed interface NewCollectionAction : MviAction {
    data class CreateNewCollection(val name: String) : NewCollectionAction
}
