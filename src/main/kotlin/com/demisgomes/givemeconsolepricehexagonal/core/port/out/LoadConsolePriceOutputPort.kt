package com.demisgomes.givemeconsolepricehexagonal.core.port.out

import com.demisgomes.givemeconsolepricehexagonal.core.domain.models.ConsolePrice

interface LoadConsolePriceOutputPort{
    fun getById(id: Int): ConsolePrice
}