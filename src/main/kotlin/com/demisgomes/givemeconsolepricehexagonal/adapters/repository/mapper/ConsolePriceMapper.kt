package com.demisgomes.givemeconsolepricehexagonal.adapters.repository.mapper

import com.demisgomes.givemeconsolepricehexagonal.adapters.repository.model.ConsolePriceJpa
import com.demisgomes.givemeconsolepricehexagonal.core.domain.models.ConsolePrice
import org.springframework.stereotype.Component

@Component
class ConsolePriceMapper{
    fun toConsolePriceJpa(consolePrice: ConsolePrice) =
            ConsolePriceJpa(
                    consoleName = consolePrice.consoleName,
                    priceInUSD = consolePrice.priceInUSD,
                    exchangeRate = consolePrice.exchangeRate,
                    taxPercentage = consolePrice.taxPercentage,
                    taxAmount = consolePrice.taxAmount,
                    profitPercentage = consolePrice.profitPercentage,
                    profitAmount = consolePrice.profitAmount,
                    priceInBRL = consolePrice.priceInBRL
            )

    fun toConsolePrice(consolePriceJpa: ConsolePriceJpa) =
            ConsolePrice(
                    id = consolePriceJpa.id,
                    consoleName = consolePriceJpa.consoleName,
                    priceInUSD = consolePriceJpa.priceInUSD,
                    exchangeRate = consolePriceJpa.exchangeRate,
                    taxPercentage = consolePriceJpa.taxPercentage,
                    taxAmount = consolePriceJpa.taxAmount,
                    profitPercentage = consolePriceJpa.profitPercentage,
                    profitAmount = consolePriceJpa.profitAmount,
                    priceInBRL = consolePriceJpa.priceInBRL
            )
}