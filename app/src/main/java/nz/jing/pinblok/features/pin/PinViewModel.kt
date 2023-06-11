package nz.jing.pinblok.features.pin

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class PinViewModel: ViewModel() {
    private val _pinState = MutableStateFlow("")
    val pinState: StateFlow<String> = _pinState

    fun updatePin(pin: String) {
        _pinState.value = pin
    }
}