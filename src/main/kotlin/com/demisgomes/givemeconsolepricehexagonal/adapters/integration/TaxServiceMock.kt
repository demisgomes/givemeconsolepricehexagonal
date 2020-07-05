package com.demisgomes.givemeconsolepricehexagonal.adapters.integration

import com.demisgomes.givemeconsolepricehexagonal.application.port.out.FetchTaxPercentagePort
import org.springframework.stereotype.Service

@Service
class TaxServiceMock : FetchTaxPercentagePort {
    override fun get(): Double {
        return 0.4
    }

}