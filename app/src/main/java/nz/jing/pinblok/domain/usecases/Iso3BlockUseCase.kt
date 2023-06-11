package nz.jing.pinblok.domain.usecases

import nz.jing.pinblok.core.utils.iso3Block

class Iso3BlockUseCase {
    fun execute(pin: String, pan: String): String {
        return iso3Block(pin, pan)
    }
}