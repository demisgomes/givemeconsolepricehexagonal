package com.demisgomes.givemeconsolepricehexagonal.adapters.repository.model

import com.fasterxml.jackson.annotation.JsonInclude
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class ConsolePriceJpa(
        @Id
        @GeneratedValue
        @JsonInclude(JsonInclude.Include.NON_NULL)
        val id: Int? = null,
        val consoleName: String,
        val priceInUSD: Double,
        val exchangeRate: Double,
        val taxPercentage: Double,
        val taxAmount: Double,
        val profitPercentage: Double,
        val profitAmount: Double,
        val priceInBRL: Double
)

