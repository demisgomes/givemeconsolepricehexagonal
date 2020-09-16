package com.demisgomes.givemeconsolepricehexagonal.core.usecase

import com.demisgomes.givemeconsolepricehexagonal.core.domain.behavior.ConsolePriceCalculator
import com.demisgomes.givemeconsolepricehexagonal.core.domain.models.ConsolePrice
import com.demisgomes.givemeconsolepricehexagonal.core.domain.models.ConsolePriceRegisterRequest
import com.demisgomes.givemeconsolepricehexagonal.core.port.`in`.RegisterConsolePriceInputPort
import com.demisgomes.givemeconsolepricehexagonal.core.port.out.FetchExchangeRateOutputPort
import com.demisgomes.givemeconsolepricehexagonal.core.port.out.FetchTaxPercentageOutputPort
import com.demisgomes.givemeconsolepricehexagonal.core.port.out.SaveConsolePriceOutputPort

class RegisterConsolePriceUseCase(private val consolePriceCalculator: ConsolePriceCalculator,
                                  private val fetchExchangeRatePort: FetchExchangeRateOutputPort,
                                  private val fetchTaxPercentagePort: FetchTaxPercentageOutputPort,
                                  private val saveConsolePricePort: SaveConsolePriceOutputPort) : RegisterConsolePriceInputPort {

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