package com.aipetite.recommender.repository

import com.aipetite.recommender.model.AppDiet
import org.springframework.data.jpa.repository.JpaRepository

interface DietRepository : JpaRepository<AppDiet, Long> {
    fun findByName(name: String): AppDiet?
}