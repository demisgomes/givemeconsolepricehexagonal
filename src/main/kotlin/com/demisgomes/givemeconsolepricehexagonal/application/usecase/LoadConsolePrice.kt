package com.demisgomes.givemeconsolepricehexagonal.application.usecase

import com.demisgomes.givemeconsolepricehexagonal.application.port.`in`.LoadConsolePriceUseCase
import com.demisgomes.givemeconsolepricehexagonal.application.port.out.LoadConsolePricePort
import com.demisgomes.givemeconsolepricehexagonal.domain.models.ConsolePrice
import org.springframework.stereotype.Service

@Service
class LoadConsolePrice(private val loadConsolePricePort: LoadConsolePricePort) : LoadConsolePriceUseCase {
    override fun getById(id: Int): ConsolePrice {
        return loadConsolePricePort.getById(id)
    }
}