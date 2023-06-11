package nz.jing.pinblok.features.pin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import nz.jing.pinblok.Screen

@Composable
fun PinScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Pin Screen")
        Button(
            onClick = { navController.navigate(Screen.Blok.route) }
        ) {
            Text (text = "Block")
        }
    }
}

@Preview
@Composable
fun PinScreenPreview() {
    PinScreen(navController = rememberNavController())
}