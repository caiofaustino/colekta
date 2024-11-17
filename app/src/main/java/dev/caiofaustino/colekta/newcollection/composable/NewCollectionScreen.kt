package dev.caiofaustino.colekta.newcollection.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.caiofaustino.colekta.newcollection.NewCollectionViewModel
import dev.caiofaustino.colekta.newcollection.mvi.NewCollectionAction
import dev.caiofaustino.colekta.newcollection.mvi.NewCollectionUiState
import dev.caiofaustino.colekta.ui.preview.PreviewThemes
import dev.caiofaustino.colekta.ui.theme.MyAppTheme

@Composable
fun NewCollectionScreen(viewModel: NewCollectionViewModel) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    NewCollection(
        state = state,
        onUserAction = { action ->
            viewModel.onUserAction(action)
        },
    )
}

@Composable
private fun NewCollection(
    state: NewCollectionUiState,
    onUserAction: (action: NewCollectionAction) -> Unit,
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
            var text by remember { mutableStateOf("") }

            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Collection Name") }
            )
            Button(
                modifier = Modifier.padding(vertical = 10.dp),
                onClick = {
                    onUserAction(NewCollectionAction.CreateNewCollection(text))
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
    MyAppTheme {
        Surface {
            NewCollection(
                state = NewCollectionUiState(),
                onUserAction = {},
            )
        }
    }
}
