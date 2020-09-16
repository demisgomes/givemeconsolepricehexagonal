package com.demisgomes.givemeconsolepricehexagonal.adapters.integration

import com.demisgomes.givemeconsolepricehexagonal.core.port.out.FetchExchangeRateOutputPort
import org.springframework.stereotype.Service

@Service
class ExchangeRateServiceMock: FetchExchangeRateOutputPort {
    override fun get(): Double {
        return 5.43
    }

}