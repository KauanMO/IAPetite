package com.aipetite.recommender.service

import com.aipetite.recommender.model.AppDiet
import com.aipetite.recommender.repository.DietRepository
import org.springframework.stereotype.Service

@Service
class DietService(
    val repository: DietRepository
) {
    fun findByName(name: String): AppDiet {
        return repository.findByName(name) ?: throw IllegalArgumentException("Invalid diet: $name")
    }
}