package nz.jing.pinblok

sealed class Screen(val route: String) {
    object Blok : Screen("blok")
    object Pin : Screen("pin")
}
