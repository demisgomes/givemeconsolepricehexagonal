package com.demisgomes.givemeconsolepricehexagonal.domain.models

data class ConsolePrice(
        val id:Int? = null,
        val consoleName: String,
        val priceInUSD: Double,
        val exchangeRate: Double,
        val taxPercentage: Double,
        val taxAmount: Double,
        val profitPercentage: Double,
        val profitAmount: Double,
        val priceInBRL: Double
)