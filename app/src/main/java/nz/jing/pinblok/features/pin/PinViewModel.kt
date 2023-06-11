package nz.jing.pinblok.features.pin

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import nz.jing.pinblok.domain.usecases.Iso3BlockUseCase
import javax.inject.Inject

@HiltViewModel
class PinViewModel @Inject constructor(
    private val iso3UseCase: Iso3BlockUseCase
): ViewModel() {
    private val _pinState = MutableStateFlow("")
    val pinState: StateFlow<String> = _pinState

    fun updatePin(pin: String) {
        _pinState.value = pin
    }

    fun getBlock(): String = iso3UseCase.execute(_pinState.value, PAN)

    companion object {
        const val PAN = "1111222233334444"
    }
}