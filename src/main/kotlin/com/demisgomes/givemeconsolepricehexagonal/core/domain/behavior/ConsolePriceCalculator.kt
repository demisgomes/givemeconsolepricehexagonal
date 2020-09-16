package com.demisgomes.givemeconsolepricehexagonal.core.domain.behavior

import com.demisgomes.givemeconsolepricehexagonal.core.domain.models.ConsolePrice

class ConsolePriceCalculator{
    fun calculateFromProfit(consoleName: String, priceInUSD: Double, profitPercentage: Double,
                            exchangeRate: Double, taxPercentage: Double): ConsolePrice {

        val priceInBRLBeforeTax = priceInUSD * exchangeRate
        val taxAmount = priceInBRLBeforeTax * taxPercentage
        val profitAmount = (priceInBRLBeforeTax + taxAmount) * (profitPercentage)

        val priceInBRL = priceInBRLBeforeTax + taxAmount + profitAmount

        return ConsolePrice(
                consoleName = consoleName,
                priceInUSD = priceInUSD,
                exchangeRate = exchangeRate,
                taxPercentage = taxPercentage,
                taxAmount = taxAmount,
                profitPercentage = profitPercentage,
                profitAmount = profitAmount,
                priceInBRL = priceInBRL
        )
    }

    fun calculateFromPriceInBRL(consoleName: String, priceInUSD: Double, priceInBRL: Double,
                                exchangeRate: Double, taxPercentage: Double): ConsolePrice {

        val priceInBRLBeforeTax = priceInUSD * exchangeRate
        val taxAmount = priceInBRLBeforeTax * taxPercentage
        val priceInBRLWithTax = priceInBRLBeforeTax+taxAmount

        val profitAmount = priceInBRL - (priceInBRLBeforeTax + taxAmount)
        val profitPercentage = profitAmount/(priceInBRLWithTax)

        return ConsolePrice(
                consoleName = consoleName,
                priceInUSD = priceInUSD,
                exchangeRate = exchangeRate,
                taxPercentage = taxPercentage,
                taxAmount = taxAmount,
                profitPercentage = profitPercentage,
                profitAmount = profitAmount,
                priceInBRL = priceInBRL
        )
    }
}