package com.demisgomes.givemeconsolepricehexagonal.application.port.out

import com.demisgomes.givemeconsolepricehexagonal.domain.models.ConsolePrice

interface SaveConsolePricePort {
    fun save(consolePrice: ConsolePrice): ConsolePrice
}