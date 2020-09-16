package com.demisgomes.givemeconsolepricehexagonal.core.port.`in`

import com.demisgomes.givemeconsolepricehexagonal.core.domain.models.ConsolePrice
import com.demisgomes.givemeconsolepricehexagonal.core.domain.models.ConsolePriceRegisterRequest

interface RegisterConsolePriceInputPort {
    fun register(consolePriceRegisterRequest: ConsolePriceRegisterRequest): ConsolePrice
}