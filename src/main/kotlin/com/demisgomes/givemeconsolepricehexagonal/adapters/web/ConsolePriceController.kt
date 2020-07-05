package com.demisgomes.givemeconsolepricehexagonal.adapters.web

import com.demisgomes.givemeconsolepricehexagonal.application.port.`in`.CalculateConsolePriceUseCase
import com.demisgomes.givemeconsolepricehexagonal.application.port.`in`.LoadConsolePriceUseCase
import com.demisgomes.givemeconsolepricehexagonal.application.port.`in`.RegisterConsolePriceUseCase
import com.demisgomes.givemeconsolepricehexagonal.application.model.ConsolePriceCalculateRequest
import com.demisgomes.givemeconsolepricehexagonal.application.model.ConsolePriceRegisterRequest
import com.demisgomes.givemeconsolepricehexagonal.domain.models.ConsolePrice
import com.demisgomes.givemeconsolepricehexagonal.application.usecase.exception.ConsolePriceNotFoundException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.util.*

@RestController
class ConsolePriceController(
        private val registerConsolePriceUseCase: RegisterConsolePriceUseCase,
        private val calculateConsolePriceUseCase: CalculateConsolePriceUseCase,
        private val loadConsolePriceUseCase: LoadConsolePriceUseCase) {

    @PostMapping("/consoles")
    fun registerConsolePrice(@RequestBody consolePriceRegisterRequest: ConsolePriceRegisterRequest): ResponseEntity<ConsolePrice> {
        val consolePrice = registerConsolePriceUseCase.register(consolePriceRegisterRequest)
        val uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(consolePrice.id)
                .toUri()
        return ResponseEntity.created(uri).build()
    }

    @GetMapping("/calculate")
    fun calculatePricefromBRL(@RequestBody consolePriceCalculateRequest: ConsolePriceCalculateRequest): ResponseEntity<ConsolePrice> {
        val consolePrice = calculateConsolePriceUseCase.calculate(consolePriceCalculateRequest)
        return ResponseEntity.ok(consolePrice)
    }

    @GetMapping("/consoles/{id}")
    fun getConsolePriceById(@PathVariable id:Int): ResponseEntity<ConsolePrice> {
        return try {
            val consolePrice = loadConsolePriceUseCase.getById(id)
            ResponseEntity.ok(consolePrice)
        }catch (ex: ConsolePriceNotFoundException){
            ResponseEntity.of(Optional.empty())
        }

    }
}