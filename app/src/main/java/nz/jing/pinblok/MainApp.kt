package nz.jing.pinblok

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import nz.jing.pinblok.features.blok.BlokScreen
import nz.jing.pinblok.features.pin.PinScreen
import nz.jing.pinblok.features.pin.PinViewModel


@Composable
fun MainApp(pinViewModel: PinViewModel) {
    val navController = rememberNavController()

    NavHost(navController, startDestination = Screen.Pin.route) {
        composable(Screen.Pin.route) { PinScreen(navController, pinViewModel) }
        composable(route = "${Screen.Blok.route}/{block}", arguments = listOf(navArgument("block") { type = NavType.StringType })) { backStackEntry ->
            val pin = backStackEntry.arguments?.getString("block") ?: ""
            BlokScreen(pin)
        }
    }
}

@Preview
@Composable
fun MainAppPreview() {
    val pinViewModel = viewModel<PinViewModel>()
    MainApp(pinViewModel)
}