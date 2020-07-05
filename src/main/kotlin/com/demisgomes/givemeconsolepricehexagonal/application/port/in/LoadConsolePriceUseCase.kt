package com.demisgomes.givemeconsolepricehexagonal.application.port.`in`

import com.demisgomes.givemeconsolepricehexagonal.domain.models.ConsolePrice


interface LoadConsolePriceUseCase{
    fun getById(id: Int) : ConsolePrice
}