package nz.jing.pinblok

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import nz.jing.pinblok.features.pin.PinViewModel
import nz.jing.pinblok.ui.theme.PinBlokTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val pinViewModel: PinViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PinBlokTheme {
                MainApp(pinViewModel = pinViewModel)
            }
        }
    }
}
