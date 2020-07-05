package com.demisgomes.givemeconsolepricehexagonal.application.port.`in`

import com.demisgomes.givemeconsolepricehexagonal.application.model.ConsolePriceRegisterRequest
import com.demisgomes.givemeconsolepricehexagonal.domain.models.ConsolePrice

interface RegisterConsolePriceUseCase {
    fun register(consolePriceRegisterRequest: ConsolePriceRegisterRequest): ConsolePrice
}