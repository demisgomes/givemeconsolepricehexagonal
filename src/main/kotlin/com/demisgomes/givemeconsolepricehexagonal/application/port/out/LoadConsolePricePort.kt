package com.demisgomes.givemeconsolepricehexagonal.application.port.out

import com.demisgomes.givemeconsolepricehexagonal.domain.models.ConsolePrice

interface LoadConsolePricePort{
    fun getById(id: Int): ConsolePrice
}