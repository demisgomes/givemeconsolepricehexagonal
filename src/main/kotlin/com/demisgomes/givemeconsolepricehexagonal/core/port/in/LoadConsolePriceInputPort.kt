package com.demisgomes.givemeconsolepricehexagonal.core.port.`in`

import com.demisgomes.givemeconsolepricehexagonal.core.domain.models.ConsolePrice

interface LoadConsolePriceInputPort{
    fun getById(id: Int) : ConsolePrice
}