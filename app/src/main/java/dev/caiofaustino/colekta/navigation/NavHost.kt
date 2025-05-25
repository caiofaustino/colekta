package dev.caiofaustino.colekta.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.caiofaustino.colekta.main.MainViewModel
import dev.caiofaustino.colekta.main.composable.MainScreen
import dev.caiofaustino.colekta.newcollection.NewCollectionViewModel
import dev.caiofaustino.colekta.newcollection.composable.NewCollectionScreen
import dev.caiofaustino.colekta.ui.theme.ColektaTheme
import kotlinx.serialization.Serializable

sealed interface DestinationScreen
@Serializable
object Main : DestinationScreen
@Serializable
object CreateNewCollection : DestinationScreen


// Sample: https://developer.android.com/guide/navigation/design#compose-minimal
@Composable
fun Colekta() {
    ColektaTheme {
        val navController = rememberNavController()
        NavHost(navController, startDestination = Main) {
            composable<Main> { backStackEntry ->
                val mainViewModel = viewModel<MainViewModel>(factory = MainViewModel.factory)
                MainScreen(viewModel = mainViewModel) {
                    navController.navigate(it)
                }
            }
            composable<CreateNewCollection> {
                val newCollectionViewModel =
                    viewModel<NewCollectionViewModel>(factory = NewCollectionViewModel.factory)
                NewCollectionScreen(newCollectionViewModel)
            }
        }
    }
}