package dev.caiofaustino.colekta.main.mvi

import dev.caiofaustino.colekta.navigation.DestinationScreen
import dev.caiofaustino.mvi.MviSideEffect

interface MainSideEffect : MviSideEffect{
    data class NavigateTo(val destination: DestinationScreen) : MainSideEffect
}