package nz.jing.pinblok.core.utils

import org.junit.Assert
import org.junit.Test

class PinBlockTest {

    @Test
    fun testIso3Block() {
        val pan = "43219876543210987"
        val pin = "1234"

        val expectedIso3PinBlock = "3412"
        val actualIso3PinBlock = iso3Block(pin, pan)

        Assert.assertTrue(actualIso3PinBlock.startsWith(expectedIso3PinBlock))
    }
}