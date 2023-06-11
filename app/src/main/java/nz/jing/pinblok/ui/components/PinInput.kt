package nz.jing.pinblok.ui.components

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PinInput(pin: String, onPinChanged: (String) -> Unit) {
    var pinError by remember { mutableStateOf(false) }
    val maxPinLength = 12
    val minPinLength = 4

    TextField(
        value = pin,
        onValueChange = { newPin ->
            if (newPin.length <= maxPinLength) {
                onPinChanged(newPin)
                pinError = false
            } else {
                pinError = true
            }
        },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
        isError = pinError,
        maxLines = 1,
        modifier = Modifier.width(200.dp)
    )
}