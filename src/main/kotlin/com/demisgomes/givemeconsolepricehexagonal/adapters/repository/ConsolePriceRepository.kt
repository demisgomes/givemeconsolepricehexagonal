package com.demisgomes.givemeconsolepricehexagonal.adapters.repository

import com.demisgomes.givemeconsolepricehexagonal.adapters.repository.jpa.ConsolePriceJpaRepository
import com.demisgomes.givemeconsolepricehexagonal.adapters.repository.mapper.ConsolePriceMapper
import com.demisgomes.givemeconsolepricehexagonal.application.port.out.LoadConsolePricePort
import com.demisgomes.givemeconsolepricehexagonal.application.port.out.SaveConsolePricePort
import com.demisgomes.givemeconsolepricehexagonal.domain.models.ConsolePrice
import com.demisgomes.givemeconsolepricehexagonal.application.usecase.exception.ConsolePriceNotFoundException
import org.springframework.stereotype.Repository

@Repository
class ConsolePriceRepository(
        private val consolePriceJpaRepository: ConsolePriceJpaRepository,
        private val consolePriceMapper: ConsolePriceMapper) : SaveConsolePricePort, LoadConsolePricePort {

    override fun save(consolePrice: ConsolePrice): ConsolePrice {
        val consolePriceJpa = consolePriceMapper.toConsolePriceJpa(consolePrice)
        val consolePriceJpaSaved = consolePriceJpaRepository.save(consolePriceJpa)

        return consolePriceMapper.toConsolePrice(consolePriceJpaSaved)
    }

    override fun getById(id: Int): ConsolePrice {
        val consolePriceJpa = consolePriceJpaRepository.findById(id).orElseThrow { ConsolePriceNotFoundException() }
        return consolePriceMapper.toConsolePrice(consolePriceJpa)
    }


}