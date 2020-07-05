package com.demisgomes.givemeconsolepricehexagonal.application.usecase

import com.demisgomes.givemeconsolepricehexagonal.application.port.`in`.CalculateConsolePriceUseCase
import com.demisgomes.givemeconsolepricehexagonal.application.model.ConsolePriceCalculateRequest
import com.demisgomes.givemeconsolepricehexagonal.application.port.out.FetchExchangeRatePort
import com.demisgomes.givemeconsolepricehexagonal.application.port.out.FetchTaxPercentagePort
import com.demisgomes.givemeconsolepricehexagonal.domain.behavior.ConsolePriceCalculator
import com.demisgomes.givemeconsolepricehexagonal.domain.models.ConsolePrice
import org.springframework.stereotype.Service

@Service
class CalculateConsolePrice(private val consolePriceCalculator: ConsolePriceCalculator,
                            private val fetchExchangeRatePort: FetchExchangeRatePort,
                            private val fetchTaxPercentagePort: FetchTaxPercentagePort) : CalculateConsolePriceUseCase {

    override fun calculate(consolePriceCalculateRequest: ConsolePriceCalculateRequest): ConsolePrice {
        val exchangeRate = fetchExchangeRatePort.get()
        val taxPercentage = fetchTaxPercentagePort.get()

        return consolePriceCalculator.calculateFromPriceInBRL(
                consoleName = consolePriceCalculateRequest.consoleName,
                priceInUSD = consolePriceCalculateRequest.priceInUSD,
                exchangeRate = exchangeRate,
                taxPercentage = taxPercentage,
                priceInBRL = consolePriceCalculateRequest.priceInBRL
        )
    }


}