package com.demisgomes.givemeconsolepricehexagonal.adapters.repository

import com.demisgomes.givemeconsolepricehexagonal.adapters.repository.jpa.ConsolePriceJpaRepository
import com.demisgomes.givemeconsolepricehexagonal.adapters.repository.mapper.ConsolePriceMapper
import com.demisgomes.givemeconsolepricehexagonal.core.domain.exception.ConsolePriceNotFoundException
import com.demisgomes.givemeconsolepricehexagonal.core.domain.models.ConsolePrice
import com.demisgomes.givemeconsolepricehexagonal.core.port.out.LoadConsolePriceOutputPort
import com.demisgomes.givemeconsolepricehexagonal.core.port.out.SaveConsolePriceOutputPort
import org.springframework.stereotype.Repository

@Repository
class ConsolePriceRepository(
        private val consolePriceJpaRepository: ConsolePriceJpaRepository,
        private val consolePriceMapper: ConsolePriceMapper) : SaveConsolePriceOutputPort, LoadConsolePriceOutputPort {

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