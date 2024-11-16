package dev.caiofaustino.starter.main.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.caiofaustino.starter.main.MainViewModel
import dev.caiofaustino.starter.main.mvi.MainAction
import dev.caiofaustino.starter.main.mvi.MainUiState
import dev.caiofaustino.starter.ui.preview.PreviewThemes
import dev.caiofaustino.starter.ui.theme.MyAppTheme

@Composable
fun MainScreen(viewModel: MainViewModel) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    Main(
        state = state,
        onUserAction = { action ->
            viewModel.onUserAction(action)
        },
    )
}

@Composable
private fun Main(
    state: MainUiState,
    onUserAction: (action: MainAction) -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier =
                Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .padding(25.dp),
        ) {
            Text(text = state.text)
            Button(
                modifier = Modifier.padding(vertical = 10.dp),
                onClick = {
                    onUserAction(MainAction.ButtonClicked)
                },
            ) {
                Text(text = "Click Me")
            }
        }
    }
}

@PreviewThemes
@Composable
private fun PreviewThemes() {
    MyAppTheme {
        Surface {
            Main(
                state = MainUiState(),
                onUserAction = {},
            )
        }
    }
}
