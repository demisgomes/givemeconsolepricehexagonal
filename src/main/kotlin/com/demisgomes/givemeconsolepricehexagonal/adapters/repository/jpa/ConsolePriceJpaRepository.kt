package com.demisgomes.givemeconsolepricehexagonal.adapters.repository.jpa

import com.demisgomes.givemeconsolepricehexagonal.adapters.repository.model.ConsolePriceJpa
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ConsolePriceJpaRepository : JpaRepository<ConsolePriceJpa, Int>