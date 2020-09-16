package com.demisgomes.givemeconsolepricehexagonal.core.usecase

import com.demisgomes.givemeconsolepricehexagonal.core.domain.models.ConsolePrice
import com.demisgomes.givemeconsolepricehexagonal.core.port.`in`.LoadConsolePriceInputPort
import com.demisgomes.givemeconsolepricehexagonal.core.port.out.LoadConsolePriceOutputPort

class LoadConsolePriceUseCase(private val loadConsolePricePort: LoadConsolePriceOutputPort) : LoadConsolePriceInputPort {
    override fun getById(id: Int): ConsolePrice {
        return loadConsolePricePort.getById(id)
    }
}