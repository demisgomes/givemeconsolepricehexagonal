package com.demisgomes.givemeconsolepricehexagonal.application.port.out

interface FetchExchangeRatePort {
    fun get(): Double
}