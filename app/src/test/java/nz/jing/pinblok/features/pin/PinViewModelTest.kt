import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import nz.jing.pinblok.features.pin.PinViewModel
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals

@ExperimentalCoroutinesApi
class PinViewModelTest {
    private lateinit var viewModel: PinViewModel

    @Before
    fun setup() {
        viewModel = PinViewModel()
    }

    @Test
    fun `test pinState is init to empty string`() = runTest {
        // When
        val result = viewModel.pinState.first()

        // Then
        assertEquals("", result)
    }

    @Test
    fun `test updatePin`() = runTest {
        // Given
        val pin = "4321"

        // When
        viewModel.updatePin(pin)

        // Then
        val result = viewModel.pinState.first()
        assertEquals(pin, result)
    }
}