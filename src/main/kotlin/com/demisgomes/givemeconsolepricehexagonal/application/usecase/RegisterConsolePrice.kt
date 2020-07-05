package com.demisgomes.givemeconsolepricehexagonal.application.usecase

import com.demisgomes.givemeconsolepricehexagonal.application.port.`in`.RegisterConsolePriceUseCase
import com.demisgomes.givemeconsolepricehexagonal.application.model.ConsolePriceRegisterRequest
import com.demisgomes.givemeconsolepricehexagonal.application.port.out.FetchExchangeRatePort
import com.demisgomes.givemeconsolepricehexagonal.application.port.out.FetchTaxPercentagePort
import com.demisgomes.givemeconsolepricehexagonal.application.port.out.SaveConsolePricePort
import com.demisgomes.givemeconsolepricehexagonal.domain.behavior.ConsolePriceCalculator
import com.demisgomes.givemeconsolepricehexagonal.domain.models.ConsolePrice
import org.springframework.stereotype.Service

@Service
class RegisterConsolePrice(private val consolePriceCalculator: ConsolePriceCalculator,
                           private val fetchExchangeRatePort: FetchExchangeRatePort,
                           private val fetchTaxPercentagePort: FetchTaxPercentagePort,
                           private val saveConsolePricePort: SaveConsolePricePort) : RegisterConsolePriceUseCase {

    override fun register(consolePriceRegisterRequest: ConsolePriceRegisterRequest): ConsolePrice {
        val exchangeRate = fetchExchangeRatePort.get()
        val taxPercentage = fetchTaxPercentagePort.get()
        val consolePrice =
                consolePriceCalculator.calculateFromProfit(
                        consoleName = consolePriceRegisterRequest.consoleName,
                        priceInUSD = consolePriceRegisterRequest.priceInUSD,
                        exchangeRate = exchangeRate,
                        taxPercentage = taxPercentage,
                        profitPercentage = consolePriceRegisterRequest.profitPercentage
                )

        return saveConsolePricePort.save(consolePrice)
    }
}