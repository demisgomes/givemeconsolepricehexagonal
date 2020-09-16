package com.demisgomes.givemeconsolepricehexagonal.core.port.out

import com.demisgomes.givemeconsolepricehexagonal.core.domain.models.ConsolePrice

interface SaveConsolePriceOutputPort {
    fun save(consolePrice: ConsolePrice): ConsolePrice
}