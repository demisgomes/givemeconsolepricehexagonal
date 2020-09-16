package com.demisgomes.givemeconsolepricehexagonal.core.domain.models

class ConsolePriceRegisterRequest (
        val consoleName: String,
        val priceInUSD: Double,
        val profitPercentage: Double
)