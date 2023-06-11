package nz.jing.pinblok.features.pin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import nz.jing.pinblok.Screen
import nz.jing.pinblok.ui.components.PinInput

@Composable
fun PinScreen(navController: NavController, pinViewModel: PinViewModel) {
    val pinState by pinViewModel.pinState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Input a 4-12 digit PIN to continue",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(16.dp)
        )
        PinInput(
            pin = pinState,
            onPinChanged = { pinViewModel.updatePin(it) }
        )
        Button(
            onClick =
            {
                val block = pinViewModel.getBlock()
                // clear pin before showing the block to user
                pinViewModel.updatePin("")
                navController.navigate("${Screen.Blok.route}/${block}")
            },
            enabled = pinState.length in 4..12,
            modifier = Modifier.padding(top = 80.dp)
        ) {
            Text (text = "Unlock")
        }
    }
}

@Preview
@Composable
fun PinScreenPreview() {
    val viewModel = viewModel<PinViewModel>()
    PinScreen(navController = rememberNavController(), pinViewModel = viewModel)
}