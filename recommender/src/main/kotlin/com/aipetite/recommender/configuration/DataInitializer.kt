package com.aipetite.recommender.configuration

import com.aipetite.recommender.model.AppDiet
import com.aipetite.recommender.repository.DietRepository
import com.aipetite.recommender.utils.DietsEnum
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
        val diets = DietsEnum.entries.toTypedArray()

        diets.forEach { diet ->
            if (dietRepository.findByName(diet.description) == null) {
                dietRepository.save(AppDiet(name = diet.description))
            }
        }
    }
}