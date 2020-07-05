package com.demisgomes.givemeconsolepricehexagonal.application.port.`in`

import com.demisgomes.givemeconsolepricehexagonal.application.model.ConsolePriceCalculateRequest
import com.demisgomes.givemeconsolepricehexagonal.domain.models.ConsolePrice

interface CalculateConsolePriceUseCase {
    fun calculate(consolePriceCalculateRequest: ConsolePriceCalculateRequest) : ConsolePrice
}