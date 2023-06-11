package nz.jing.pinblok

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import nz.jing.pinblok.features.blok.BlokScreen
import nz.jing.pinblok.features.pin.PinScreen



@Composable
fun MainApp() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = Screen.Pin.route) {
        composable(Screen.Blok.route) { BlokScreen() }
        composable(Screen.Pin.route) { PinScreen(navController) }
    }
}

@Preview
@Composable
fun MainAppPreview() {
    MainApp()
}