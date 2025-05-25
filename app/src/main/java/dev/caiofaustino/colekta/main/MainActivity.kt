package dev.caiofaustino.colekta.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dev.caiofaustino.colekta.navigation.Colekta

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            val mainViewModel = viewModel<MainViewModel>(factory = MainViewModel.factory)
//            MyAppTheme {
//                MainScreen(viewModel = mainViewModel)
//            }
            Colekta()
        }
    }
}
