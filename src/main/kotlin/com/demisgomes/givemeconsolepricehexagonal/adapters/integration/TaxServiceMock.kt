package com.demisgomes.givemeconsolepricehexagonal.adapters.integration

import com.demisgomes.givemeconsolepricehexagonal.core.port.out.FetchTaxPercentageOutputPort
import org.springframework.stereotype.Service

@Service
class TaxServiceMock : FetchTaxPercentageOutputPort {
    override fun get(): Double {
        return 0.4
    }

}