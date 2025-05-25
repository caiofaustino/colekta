package dev.caiofaustino.colekta.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.caiofaustino.colekta.main.MainViewModel
import dev.caiofaustino.colekta.main.composable.MainScreen
import dev.caiofaustino.colekta.navigation.DestinationScreen.MainScreen
import dev.caiofaustino.colekta.navigation.DestinationScreen.NewCollectionScreen
import dev.caiofaustino.colekta.newcollection.NewCollectionViewModel
import dev.caiofaustino.colekta.newcollection.composable.NewCollectionScreen
import dev.caiofaustino.colekta.ui.theme.ColektaTheme
import kotlinx.serialization.Serializable

sealed interface DestinationScreen {
    @Serializable
    object MainScreen : DestinationScreen
    @Serializable
    object NewCollectionScreen : DestinationScreen
}

// Sample: https://developer.android.com/guide/navigation/design#compose-minimal
@Composable
fun Colekta() {
    ColektaTheme {
        val navController = rememberNavController()
        NavHost(navController, startDestination = MainScreen) {
            composable<MainScreen> { backStackEntry ->
                val mainViewModel = viewModel<MainViewModel>(factory = MainViewModel.factory)
                MainScreen(viewModel = mainViewModel) {
                    navController.navigate(it)
                }
            }
            composable<NewCollectionScreen> {
                val newCollectionViewModel =
                    viewModel<NewCollectionViewModel>(factory = NewCollectionViewModel.factory)
                NewCollectionScreen(newCollectionViewModel)
            }
        }
    }
}