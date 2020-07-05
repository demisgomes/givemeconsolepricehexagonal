package com.demisgomes.givemeconsolepricehexagonal.adapters.integration

import com.demisgomes.givemeconsolepricehexagonal.application.port.out.FetchExchangeRatePort
import org.springframework.stereotype.Service

@Service
class ExchangeRateServiceMock: FetchExchangeRatePort {
    override fun get(): Double {
        return 5.43
    }

}