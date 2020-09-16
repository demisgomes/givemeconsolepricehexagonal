package com.demisgomes.givemeconsolepricehexagonal.config

import com.demisgomes.givemeconsolepricehexagonal.core.domain.behavior.ConsolePriceCalculator
import com.demisgomes.givemeconsolepricehexagonal.core.port.`in`.CalculateConsolePriceInputPort
import com.demisgomes.givemeconsolepricehexagonal.core.port.`in`.LoadConsolePriceInputPort
import com.demisgomes.givemeconsolepricehexagonal.core.port.`in`.RegisterConsolePriceInputPort
import com.demisgomes.givemeconsolepricehexagonal.core.port.out.FetchExchangeRateOutputPort
import com.demisgomes.givemeconsolepricehexagonal.core.port.out.FetchTaxPercentageOutputPort
import com.demisgomes.givemeconsolepricehexagonal.core.port.out.LoadConsolePriceOutputPort
import com.demisgomes.givemeconsolepricehexagonal.core.port.out.SaveConsolePriceOutputPort
import com.demisgomes.givemeconsolepricehexagonal.core.usecase.CalculateConsolePriceUseCase
import com.demisgomes.givemeconsolepricehexagonal.core.usecase.LoadConsolePriceUseCase
import com.demisgomes.givemeconsolepricehexagonal.core.usecase.RegisterConsolePriceUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CoreInjection{
    @Bean
    fun consolePriceCalculator() = ConsolePriceCalculator()

    @Bean
    fun calculateConsolePrice(
            consolePriceCalculator: ConsolePriceCalculator,
            fetchExchangeRateOutputPort: FetchExchangeRateOutputPort,
            fetchTaxPercentageOutputPort: FetchTaxPercentageOutputPort): CalculateConsolePriceInputPort {

        return CalculateConsolePriceUseCase(
                consolePriceCalculator,
                fetchExchangeRateOutputPort,
                fetchTaxPercentageOutputPort
        )
    }

    @Bean
    fun loadConsolePrice(loadConsolePriceOutputPort: LoadConsolePriceOutputPort): LoadConsolePriceInputPort {
        return LoadConsolePriceUseCase(loadConsolePriceOutputPort)
    }

    @Bean
    fun registerConsolePrice(
            consolePriceCalculator: ConsolePriceCalculator,
            fetchExchangeRateOutputPort: FetchExchangeRateOutputPort,
            fetchTaxPercentageOutputPort: FetchTaxPercentageOutputPort,
            saveConsolePriceOutputPort: SaveConsolePriceOutputPort): RegisterConsolePriceInputPort {

        return RegisterConsolePriceUseCase(
                consolePriceCalculator,
                fetchExchangeRateOutputPort,
                fetchTaxPercentageOutputPort,
                saveConsolePriceOutputPort
        )
    }

}