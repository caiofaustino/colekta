package dev.caiofaustino.colekta.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.caiofaustino.colekta.main.composable.MainScreen
import dev.caiofaustino.colekta.ui.theme.MyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val mainViewModel = viewModel<MainViewModel>(factory = MainViewModel.factory)
            MyAppTheme {
                MainScreen(viewModel = mainViewModel)
            }
        }
    }
}
