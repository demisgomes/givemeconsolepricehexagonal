package com.demisgomes.givemeconsolepricehexagonal.core.port.`in`

import com.demisgomes.givemeconsolepricehexagonal.core.domain.models.ConsolePrice
import com.demisgomes.givemeconsolepricehexagonal.core.domain.models.ConsolePriceCalculateRequest

interface CalculateConsolePriceInputPort {
    fun calculate(consolePriceCalculateRequest: ConsolePriceCalculateRequest) : ConsolePrice
}