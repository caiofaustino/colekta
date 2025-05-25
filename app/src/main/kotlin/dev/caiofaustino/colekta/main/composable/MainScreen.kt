package dev.caiofaustino.colekta.main.composable

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
import dev.caiofaustino.colekta.main.MainViewModel
import dev.caiofaustino.colekta.main.mvi.MainAction
import dev.caiofaustino.colekta.main.mvi.MainUiState
import dev.caiofaustino.colekta.navigation.DestinationScreen
import dev.caiofaustino.colekta.ui.preview.PreviewThemes
import dev.caiofaustino.colekta.ui.theme.ColektaTheme

@Composable
fun MainScreen(
    viewModel: MainViewModel,
    navigate: (destination: DestinationScreen) -> Unit
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    val navigation by viewModel.navigation.collectAsStateWithLifecycle(null)

    navigation?.let { navigate(it) }

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
                    onUserAction(MainAction.CreateCollection)
                },
            ) {
                Text(text = "Create Collection")
            }
        }
    }
}

@PreviewThemes
@Composable
private fun PreviewThemes() {
    ColektaTheme {
        Surface {
            Main(
                state = MainUiState(),
                onUserAction = {},
            )
        }
    }
}
