package dev.caiofaustino.starter.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.caiofaustino.starter.main.composable.MainScreen
import dev.caiofaustino.starter.ui.theme.MyAppTheme

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
