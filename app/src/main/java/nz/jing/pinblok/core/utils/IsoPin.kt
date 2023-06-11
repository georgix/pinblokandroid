package nz.jing.pinblok.core.utils

import kotlin.experimental.xor

fun iso3Block(pin: String, pan: String): String {
    val randomDigits = (1..10).joinToString("") { (0..15).random().toString(16).uppercase() }
    val pinBlock = "3${pin.length}${pin}${randomDigits}".take(16)
    val panBlock = pan.takeLast(12).padStart(16, '0')
    return xorHexStrings(pinBlock, panBlock)
}

private fun xorHexStrings(hexString1: String, hexString2: String): String {
    val byteArray1 = hexString1.chunked(2).map { it.toInt(16).toByte() }.toByteArray()
    val byteArray2 = hexString2.chunked(2).map { it.toInt(16).toByte() }.toByteArray()

    val resultByteArray = ByteArray(byteArray1.size)
    for (i in byteArray1.indices) {
        resultByteArray[i] = (byteArray1[i] xor byteArray2[i])
    }

    return resultByteArray.joinToString("") { "%02x".format(it) }
}