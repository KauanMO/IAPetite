package com.aipetite.recommender.configuration

import com.aipetite.recommender.model.AppDiet
import com.aipetite.recommender.repository.DietRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import org.springframework.util.FileCopyUtils
import java.nio.charset.StandardCharsets

@Configuration
class DataInitializer {
    @Bean
    fun initDiets(dietRepository: DietRepository) = CommandLineRunner {
        val resource = ClassPathResource("diets.txt")
        val rawDiets = String(FileCopyUtils.copyToByteArray(resource.inputStream), StandardCharsets.UTF_8)
        val diets = rawDiets.lines()
            .map { it.trim() }
            .filter { it.isNotEmpty() }

        diets.forEach { name ->
            if (dietRepository.findByName(name) == null) {
                dietRepository.save(AppDiet(name = name))
            }
        }
    }
}