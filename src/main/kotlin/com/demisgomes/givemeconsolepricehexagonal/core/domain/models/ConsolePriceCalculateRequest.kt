package com.demisgomes.givemeconsolepricehexagonal.core.domain.models

class ConsolePriceCalculateRequest (
        val consoleName: String,
        val priceInUSD: Double,
        val priceInBRL: Double
)