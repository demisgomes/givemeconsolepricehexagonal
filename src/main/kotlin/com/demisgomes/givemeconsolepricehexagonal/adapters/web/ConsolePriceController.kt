package com.demisgomes.givemeconsolepricehexagonal.adapters.web

import com.demisgomes.givemeconsolepricehexagonal.core.domain.exception.ConsolePriceNotFoundException
import com.demisgomes.givemeconsolepricehexagonal.core.domain.models.ConsolePrice
import com.demisgomes.givemeconsolepricehexagonal.core.domain.models.ConsolePriceCalculateRequest
import com.demisgomes.givemeconsolepricehexagonal.core.domain.models.ConsolePriceRegisterRequest
import com.demisgomes.givemeconsolepricehexagonal.core.port.`in`.CalculateConsolePriceInputPort
import com.demisgomes.givemeconsolepricehexagonal.core.port.`in`.LoadConsolePriceInputPort
import com.demisgomes.givemeconsolepricehexagonal.core.port.`in`.RegisterConsolePriceInputPort
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.util.*

@RestController
class ConsolePriceController(
        private val registerConsolePriceInputPort: RegisterConsolePriceInputPort,
        private val calculateConsolePriceInputPort: CalculateConsolePriceInputPort,
        private val loadConsolePriceInputPort: LoadConsolePriceInputPort) {

    @PostMapping("/consoles")
    fun registerConsolePrice(@RequestBody consolePriceRegisterRequest: ConsolePriceRegisterRequest): ResponseEntity<ConsolePrice> {
        val consolePrice = registerConsolePriceInputPort.register(consolePriceRegisterRequest)
        val uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(consolePrice.id)
                .toUri()
        return ResponseEntity.created(uri).build()
    }

    @GetMapping("/calculate")
    fun calculatePricefromBRL(@RequestBody consolePriceCalculateRequest: ConsolePriceCalculateRequest): ResponseEntity<ConsolePrice> {
        val consolePrice = calculateConsolePriceInputPort.calculate(consolePriceCalculateRequest)
        return ResponseEntity.ok(consolePrice)
    }

    @GetMapping("/consoles/{id}")
    fun getConsolePriceById(@PathVariable id:Int): ResponseEntity<ConsolePrice> {
        return try {
            val consolePrice = loadConsolePriceInputPort.getById(id)
            ResponseEntity.ok(consolePrice)
        }catch (ex: ConsolePriceNotFoundException){
            ResponseEntity.of(Optional.empty())
        }

    }
}