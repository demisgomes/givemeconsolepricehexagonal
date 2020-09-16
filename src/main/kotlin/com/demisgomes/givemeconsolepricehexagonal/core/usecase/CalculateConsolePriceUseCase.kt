package com.demisgomes.givemeconsolepricehexagonal.core.usecase

import com.demisgomes.givemeconsolepricehexagonal.core.domain.behavior.ConsolePriceCalculator
import com.demisgomes.givemeconsolepricehexagonal.core.domain.models.ConsolePrice
import com.demisgomes.givemeconsolepricehexagonal.core.domain.models.ConsolePriceCalculateRequest
import com.demisgomes.givemeconsolepricehexagonal.core.port.`in`.CalculateConsolePriceInputPort
import com.demisgomes.givemeconsolepricehexagonal.core.port.out.FetchExchangeRateOutputPort
import com.demisgomes.givemeconsolepricehexagonal.core.port.out.FetchTaxPercentageOutputPort

class CalculateConsolePriceUseCase(private val consolePriceCalculator: ConsolePriceCalculator,
                                   private val fetchExchangeRatePort: FetchExchangeRateOutputPort,
                                   private val fetchTaxPercentagePort: FetchTaxPercentageOutputPort) : CalculateConsolePriceInputPort {

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